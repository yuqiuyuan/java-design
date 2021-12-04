import java.util.Stack;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.util.concurrent.ThreadLocalRandom;


@Slf4j
@Getter
public class VirtualMachine {

  private final Stack<Integer> stack = new Stack<>();
  /**
   * 一个虚拟机里两个 向导
   */
  private final Wizard[] wizards = new Wizard[2];

  public VirtualMachine () {
    wizards[0] = new Wizard(randomInt(3, 32), randomInt(3, 32), randomInt(3, 32), 0, 0);
    wizards[1] = new Wizard(randomInt(3, 32), randomInt(3, 32), randomInt(3, 32), 0, 0);
  }

  public VirtualMachine (Wizard wizard1, Wizard wizard2) {
    wizards[0] = wizard1;
    wizards[1] = wizard2;
  }

  public void execute (int[] bytecodes) {
    for (int i = 0; i < bytecodes.length; i++) {
      Instruction instruction = Instruction.getInstruction(bytecodes[i]);
      if (null == instruction) {
        continue;
      }
      switch (instruction) {
        case LITERAL:
          var value = bytecodes[++i];
          stack.push(value);
          break;
        case SET_AGILITY:
          var amount = stack.pop();
          var wizard = stack.pop();
          setAgility(wizard, amount);
          break;
        case SET_WISDOM:
          amount = stack.pop();
          wizard = stack.pop();
          setWisdom(wizard, amount);
          break;
        case SET_HEALTH:
          amount = stack.pop();
          wizard = stack.pop();
          setHealth(wizard, amount);
          break;
        case GET_HEALTH:
          wizard = stack.pop();
          stack.push(getHealth(wizard));
          break;
        case GET_AGILITY:
          wizard = stack.pop();
          stack.push(getAgility(wizard));
          break;
        case ADD:
          var a = stack.pop();
          var b = stack.pop();
          stack.push(a + b);
          break;
        case DIVIDE:
          a = stack.pop();
          b = stack.pop();
          stack.push(b / a);
          break;
        case PLAY_SOUND:
          wizard = stack.pop();
          getWizards()[wizard].playSound();
          break;
        case SPAWN_PARTICLES:
          wizard = stack.pop();
          getWizards()[wizard].spawnParticles();
          break;
        case REDUCE:
          a = stack.pop();
          b = stack.pop();
          stack.push(b - a);
          break;
        default:
          throw new IllegalArgumentException("Invalid instruction value");
      }
      log.trace("Executed {} ,Stack contains {}", instruction.name(), getStack());
    }
  }

  private Integer getAgility (Integer wizard) {
    return wizards[wizard].getAgility();
  }

  private Integer getHealth (Integer wizard) {
    return wizards[wizard].getHealth();
  }

  private void setHealth (Integer wizard, Integer amount) {
    wizards[wizard].setHealth(amount);
  }

  private void setWisdom (Integer wizard, Integer amount) {
    wizards[wizard].setWisdom(amount);
  }


  public void setAgility (int wizard, int amount) {
    wizards[wizard].setAgility(amount);
  }

  private int randomInt (int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }
}
