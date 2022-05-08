package com.danielblanco.arquitecturasmodernas.hexagonal.domain;

public class MatchResult {

  private final PlayerPoints pointsPlayer1;
  private final PlayerPoints pointsPlayer2;
  private final Status matchStatus;

  public MatchResult(String player1, int setsPlayer1, String player2, int setsPlayer2,
    Status matchStatus) {
    this.pointsPlayer1 = new PlayerPoints(player1, setsPlayer1);
    this.pointsPlayer2 = new PlayerPoints(player2, setsPlayer2);
    this.matchStatus = matchStatus;
  }

  public PlayerPoints getPointsPlayer1() {
    return pointsPlayer1;
  }

  public PlayerPoints getPointsPlayer2() {
    return pointsPlayer2;
  }

  public Status getMatchStatus() {
    return matchStatus;
  }
}
