package com;

import com.Kingdom.FactoryMaker;
import com.Kingdom.FactoryMaker.KingdomType;

public class App implements Runnable{

  private final Kingdom kingdom = new Kingdom();

  public Kingdom getKingdom(){
    return kingdom;
  }

  public static void main (String[] args) {
    App app = new App();
    app.run();
  }

  @Override
  public void run () {
    System.out.println("elf kingdom");
    createKingdom(KingdomType.ELF);
    System.out.println(kingdom.getKing());
    System.out.println("orc kingdom");
    createKingdom(KingdomType.ORC);
    System.out.println(kingdom.getKing());
  }

  public void createKingdom(final Kingdom.FactoryMaker.KingdomType kingdomType){
    KingdomFactory kingdomFactory = FactoryMaker.makeFactory(kingdomType);
    kingdom.setKing(kingdomFactory.createKing());
    kingdom.setArmy(kingdomFactory.createArmy());
    kingdom.setCastle(kingdomFactory.createCastle());
  }
}
