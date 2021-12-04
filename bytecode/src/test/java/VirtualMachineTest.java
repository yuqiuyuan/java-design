import lombok.var;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualMachineTest {

  @Test
  void testLiteral () {
    int[] bytecode = new int[2];
    bytecode[0] = Instruction.LITERAL.getIntValue();
    bytecode[1] = 10;

    VirtualMachine vm = new VirtualMachine();
    vm.execute(bytecode);

    assertEquals(1, vm.getStack().size());
    assertEquals(Integer.valueOf(10), vm.getStack().pop());
  }


  /**
   * 给虚拟机设置健康值50
   */
  @Test
  void testSetHealth () {
    var wizardNumber = 0;
    var bytecode = new int[5];
    bytecode[0] = Instruction.LITERAL.getIntValue();
    bytecode[1] = wizardNumber;
    bytecode[2] = Instruction.LITERAL.getIntValue();
    bytecode[3] = 50; // health amount
    bytecode[4] = Instruction.SET_HEALTH.getIntValue();

    var vm = new VirtualMachine();
    vm.execute(bytecode);
    assertEquals(50, vm.getWizards()[wizardNumber].getHealth());
  }

  @Test
  void testSetAgility () {
    int[] bytecode = {Instruction.LITERAL.getIntValue(), 1, Instruction.LITERAL.getIntValue(), 80, Instruction.SET_AGILITY.getIntValue()};
    var vm = new VirtualMachine();
    vm.execute(bytecode);
    assertEquals(80, vm.getWizards()[1].getAgility());
  }


}