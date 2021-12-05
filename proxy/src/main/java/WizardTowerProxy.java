import lombok.extern.slf4j.Slf4j;

/**
 * The proxy controlling access to the IvoryTower
 */
@Slf4j
public class WizardTowerProxy implements WizardTower {

  private static final int NUM_WIZARDS_ALLOWED = 3;

  private int numWizard;

  private final WizardTower tower;

  public WizardTowerProxy (WizardTower tower) {
    this.tower = tower;
  }

  @Override
  public void enter (Wizard wizard) {
    if (numWizard < NUM_WIZARDS_ALLOWED) {
      tower.enter(wizard);
      numWizard++;
    } else {
      log.info("{} is not allowed to enter !", wizard);
    }
  }
}
