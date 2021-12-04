import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Slf4j
public class App {

  /**
   * 系统指令，是由字母组合 + 数组构成的
   */
  private static final String LITERAL_0 = "LITERAL 0";
  private static final String HEALTH_PATTERN = "%s_HEALTH";
  private static final String GET_AGILITY = "GET_AGILITY";
  private static final String GET_WISDOM = "GET_WISDOM";
  private static final String ADD = "ADD";
  private static final String REDUCE = "REDUCE";
  private static final String LITERAL_1 = "LITERAL 1";
  private static final String LITERAL_5 = "LITERAL 5";
  private static final String LITERAL_10 = "LITERAL 10";
  private static final String DIVIDE = "DIVIDE";

  public static void main (String[] args) {
    var vm = new VirtualMachine(new Wizard(100, 100, 100, 0, 0), new Wizard(100, 100, 100, 0, 0));
    Script script = new Script();
    do {
      switch (script.action()) {
        case Script.A:
          aPlaySound(vm);
          break;
        case Script.B:
          bPlaySound(vm);
          break;
        case Script.C:
          aPawnedParticles(vm);
          break;
        case Script.D:
          bPawnedParticles(vm);
          break;
      }
    } while (vm.getWizards()[0].getHealth() > 0 && vm.getWizards()[1].getHealth() > 0);
    log.info("Game over~! {} win ", vm.getWizards()[0].getHealth() > vm.getWizards()[1].getHealth() ? 0 : 1);
    log.info("0 wizard's health is : {}", vm.getWizards()[0].getHealth());
    log.info("1 wizard's health is : {}", vm.getWizards()[1].getHealth());
  }


  private static void aPlaySound (VirtualMachine vm) {
    log.info("巫师 A 冲 B 大吼一声");
    // 给1号巫师减5分
    doHealth(vm, LITERAL_1, LITERAL_5);
  }

  private static void bPlaySound (VirtualMachine vm) {
    log.info("巫师 B 冲 A 大吼一声");
    // 给0号巫师减5分
    doHealth(vm, LITERAL_0, LITERAL_5);
  }

  private static void bPawnedParticles (VirtualMachine vm) {
    // 给0号巫师减5分
    log.info("巫师 B 向 A 施法 缠绕");
    doHealth(vm, LITERAL_0, LITERAL_10);
  }

  private static void aPawnedParticles (VirtualMachine vm) {
    // 给1号巫师减5分
    log.info("巫师 A 向 B 施法 寄生");
    doHealth(vm, LITERAL_1, LITERAL_10);
  }

  private static void doHealth (VirtualMachine vm, String wizard, String reduceHealth) {
    vm.execute(InstructionConverterUtil.convertToByteCode(wizard));
    vm.execute(InstructionConverterUtil.convertToByteCode(wizard));
    vm.execute(InstructionConverterUtil.convertToByteCode(String.format(HEALTH_PATTERN, "GET")));
    vm.execute(InstructionConverterUtil.convertToByteCode(reduceHealth));
    vm.execute(InstructionConverterUtil.convertToByteCode(REDUCE));
    vm.execute(InstructionConverterUtil.convertToByteCode(String.format(HEALTH_PATTERN, "SET")));
  }
}
