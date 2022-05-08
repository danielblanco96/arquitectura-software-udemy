package com.danielblanco.arquitecturasmodernas.hexagonal.domain;

import java.util.HashMap;
import java.util.Map;

public class TennisSet {
  private static final int SET_POINTS = 6;
  private Map<String, Integer> points;

  public TennisSet(String player1, String player2) {
    points = new HashMap<String, Integer>();
    points.put(player1, 0);
    points.put(player2, 0);
  }

  public boolean addPoint(String player) {
    int playerPoints = points.get(player);
    playerPoints++;
    if(playerPoints == SET_POINTS) return true;
    points.put(player, playerPoints);
    return false;
  }
}
