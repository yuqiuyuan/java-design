import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Instruction {
  LITERAL(1),         // e.g. "LITERAL 0" , push 0 to stack ,将命令后面的参数推入到栈中
  SET_HEALTH(2),      // e.g. "SET_HEALTH" , 依次在stack弹出 health 值，和 wizard 值，然后往对应的对象中进行属性设置操作
  SET_WISDOM(3),      // e.g. "SET_WISDOM" ， 依次在stack弹出 wisdom 值，和 wizard 值，然后往对应的对象中进行属性设置操作
  SET_AGILITY(4),     // e.g. "SET_AGILITY" ， 依次在stack弹出 agility 值，和 wizard 值，然后往对应的对象中进行属性设置操作
  PLAY_SOUND(5),      // e.g. "PLAY_SOUND" ，
  SPAWN_PARTICLES(6),
  GET_HEALTH(7),
  GET_AGILITY(8),
  GET_WISDOM(9),
  ADD(10),
  DIVIDE(11),
  REDUCE(12);

  private final int intValue;

  public static Instruction getInstruction (int value) {
    return Arrays.stream(values()).filter(i -> i.getIntValue() == value).findAny().orElse(null);
  }
}
