package com.danielblanco.arquitecturasmodernas.hexagonal.domain;

public class PlayerPoints {

  private String player;
  private int setsWon;

  public PlayerPoints(String player, int setsWon) {
    this.player = player;
    this.setsWon = setsWon;
  }

  public String getPlayer() {
    return player;
  }

  public int getSetsWon() {
    return setsWon;
  }
}
