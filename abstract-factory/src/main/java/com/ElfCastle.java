package com;

public class ElfCastle implements Castle{

  private final String DESCRIPTION = "This is the elven castle!";

  @Override
  public String getDescription () {
    return DESCRIPTION;
  }
}
