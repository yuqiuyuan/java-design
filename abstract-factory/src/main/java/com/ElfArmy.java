package com;

/**
 * ElfKing
 */
public class ElfArmy implements Army {

  private final String DESCRIPTION = "This is the elven army!";

  @Override
  public String getDescription () {
    return DESCRIPTION;
  }
}
