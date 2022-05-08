package com.danielblanco.arquitecturasmodernas.hexagonal.domain;


public class Player {

  private String name;
  private int setsWon;
  private int warnings;
  private int maxWarnings;

  public Player(String name, int maxWarnings) {
    this.name = name;
    this.warnings = 0;
    this.maxWarnings = maxWarnings;
    setsWon = 0;
  }

  public int addSet() {
    return ++setsWon;
  }

  public void warn() {
    warnings++;
    if (warnings == maxWarnings) {
      throw new MaxWarningReachedException();
    }
  }

  public int getSetsWon() {
    return setsWon;
  }

  public String getName() {
    return name;
  }
}
