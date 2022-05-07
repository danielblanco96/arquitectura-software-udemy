package com.danielblanco.arquitecturasmodernas.hexagonal.application.dto;

public class TennisMatchDTO {

  private String id;
  private String player1;
  private int setsPlayer1;
  private String player2;
  private int setsPlayer2;
  private String winner;
  private String status;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPlayer1() {
    return player1;
  }

  public void setPlayer1(String player1) {
    this.player1 = player1;
  }

  public String getPlayer2() {
    return player2;
  }

  public void setPlayer2(String player2) {
    this.player2 = player2;
  }

  public String getWinner() {
    return winner;
  }

  public void setWinner(String winner) {
    this.winner = winner;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getSetsPlayer1() {
    return setsPlayer1;
  }

  public void setSetsPlayer1(int setsPlayer1) {
    this.setsPlayer1 = setsPlayer1;
  }

  public int getSetsPlayer2() {
    return setsPlayer2;
  }

  public void setSetsPlayer2(int setsPlayer2) {
    this.setsPlayer2 = setsPlayer2;
  }
}



