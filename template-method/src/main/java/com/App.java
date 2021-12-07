package com;

import lombok.var;

/**
 * Template Method defines a skeleton for an algorithm. The algorithm subclass provide implementation for the blank parts.
 * <p>In this example {@link HalflingThief} contains {@link StealingMethod} that can bo changed.
 * First the thief hits with {@link HitAndRunMethod} and then with {@link SubtleMethod}
 */
public class App {

  public static void main (String[] args) {
    var thief = new HalflingThief(new HitAndRunMethod());
    thief.steal();
    thief.changeMethod(new SubtleMethod());
    thief.steal();
  }
}
