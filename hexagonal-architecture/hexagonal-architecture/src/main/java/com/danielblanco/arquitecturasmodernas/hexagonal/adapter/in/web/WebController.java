package com.danielblanco.arquitecturasmodernas.hexagonal.adapter.in.web;

import com.danielblanco.arquitecturasmodernas.hexagonal.application.TennisService;
import com.danielblanco.arquitecturasmodernas.hexagonal.application.dto.TennisMatchDTO;
import com.danielblanco.arquitecturasmodernas.hexagonal.port.in.web.WebPort;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class WebController implements WebPort {

  @Autowired
  private TennisService tennisService;

  @Override
  public TennisMatchDTO start(Map<String, String> players) {
    String player1 = players.get("player1");
    String player2 = players.get("player2");
    if (player1 == null || player2 == null) {
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST);
    }

    return tennisService.startMatch(player1, player2);
  }

  @Override
  public TennisMatchDTO addPoint(String matchId, String player) {
    return tennisService.addPoint(matchId, player);
  }

  @Override
  public void warn(String matchId, String player) {
    // Warn player
  }
}
