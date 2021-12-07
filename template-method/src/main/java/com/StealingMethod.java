package com;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Slf4j
public abstract class StealingMethod {

  protected abstract String pickTarget ();

  protected abstract void confuseTarget (String target);

  protected abstract void stealTheItem (String target);

  public void steal(){
    var target = pickTarget();
    confuseTarget(target);
    stealTheItem(target);
  }
}
