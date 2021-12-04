import java.util.concurrent.ThreadLocalRandom;

/**
 * 游戏剧本 剧情随机生成～！
 */
public class Script {

  // A 巫师怒吼
  public static final int A = 0;
  // A 巫师打枪
  public static final int B = 1;
  // B 巫师怒吼
  public static final int C = 2;
  // B 巫师打枪
  public static final int D = 3;

  int action () {
    return ThreadLocalRandom.current().nextInt(0, 100) % 4;
  }

}
