import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 此类表示游戏对象(巫师)，这些对象的属性能够通过虚拟机进行更改
 */
@Getter
@Setter
@Slf4j
@AllArgsConstructor
public class Wizard {

  //  健康
  private int health;
  //  敏捷
  private int agility;
  //  智慧
  private int wisdom;
  //  播放声音的次数
  private int numberOfPlayedSounds;
  //  打枪次数
  private int numberOfSpawnedParticles;

  public void playSound () {
    log.info("playing sound");
    numberOfPlayedSounds++;
  }

  public void spawnParticles () {
    log.info("spawning particles");
    numberOfSpawnedParticles++;
  }

}
