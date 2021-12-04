import lombok.var;

public class InstructionConverterUtil {

  public static int[] convertToByteCode (String instructions) {
    if (instructions == null || instructions.trim().length() == 0) {
      return new int[0];
    }
//    把指令名称 与 指令参数拆分开
    var splitInstructions = instructions.trim().split(" ");
    var bytecode = new int[splitInstructions.length];
    for (int i = 0; i < splitInstructions.length; i++) {
      if (isValidInstruction(splitInstructions[i])) {
        bytecode[i] = Instruction.valueOf(splitInstructions[i]).getIntValue();
      } else if (isValidInt(splitInstructions[i])) {
        bytecode[i] = Integer.parseInt(splitInstructions[i]);
      } else {
        var errorMessage = "Invalid instruction or number: " + splitInstructions[i];
        throw new IllegalArgumentException(errorMessage);
      }
    }
    return bytecode;
  }

  private static boolean isValidInstruction (String instruction) {
    try {
      Instruction.valueOf(instruction);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  private static boolean isValidInt (String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }


}
