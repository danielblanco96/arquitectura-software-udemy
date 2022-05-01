package com.danielblanco.examples.ddd.domain;

import java.util.*;
import java.util.stream.Collectors;

public class TennisMatch {
  private static final int NUMBER_OF_SETS = 5;
  private static final int MAX_WARNINGS = 3;

  private Map<String, Player> players;
  String player1;
  String player2;
  private Status status;
  private List<TennisSet> sets;
  private TennisSet currentSet;
  private Player winner;

  public TennisMatch(String player1, String player2) {
    players = new HashMap<String, Player>();
    this.player1 = player1;
    this.player2 = player2;
    players.put(player1, new Player(player1, MAX_WARNINGS));
    players.put(player2, new Player(player2, MAX_WARNINGS));
    this.status = Status.NOT_STARTED;
    this.sets = new ArrayList<TennisSet>();
  }

  public void start() {
    if(this.status == Status.NOT_STARTED) {
      this.status = Status.IN_PROGRESS;
    }
  }

  private void finish(String winnerPlayer) {
    if(this.status == Status.IN_PROGRESS) {
      this.status = Status.FINISHED;
    }
    
    winner = players.get(winnerPlayer);
  }

  public void point(String player) {
    if(currentSet.addPoint(player)) {
      if(players.get(player).addSet() == NUMBER_OF_SETS) {
        finish(player);
        return;
      }

      advanceSet();
    }
  }

  private void advanceSet() {
    currentSet = new TennisSet(player1, player2);
    sets.add(currentSet);
  }

  public void warn(String player) {
    try {
      players.get(player).warn();
    } catch(MaxWarningReachedException e) {
      String winnerName = player.equals(player1) ? player1 : player2;
      finish(winnerName);
    }
  }

  public Player getWinner() {
    if(status == Status.FINISHED && winner != null) {
      return winner;
    }

    throw new NoWinnerException();
  }
}



