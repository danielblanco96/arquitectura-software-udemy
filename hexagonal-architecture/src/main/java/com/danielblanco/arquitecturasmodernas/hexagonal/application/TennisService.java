package com.danielblanco.arquitecturasmodernas.hexagonal.application;

import com.danielblanco.arquitecturasmodernas.hexagonal.application.dto.HumidityDTO;
import com.danielblanco.arquitecturasmodernas.hexagonal.application.dto.TennisMatchDTO;
import com.danielblanco.arquitecturasmodernas.hexagonal.domain.MatchResult;
import com.danielblanco.arquitecturasmodernas.hexagonal.domain.Status;
import com.danielblanco.arquitecturasmodernas.hexagonal.domain.TennisMatch;
import com.danielblanco.arquitecturasmodernas.hexagonal.port.out.db.DbPort;
import com.danielblanco.arquitecturasmodernas.hexagonal.port.out.notification.OutNotificationPort;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TennisService {

  private Map<String, TennisMatch> activeMatches = new HashMap<>();

  @Autowired
  private DbPort dbPort;

  @Autowired
  private OutNotificationPort queuePort;

  public TennisMatchDTO startMatch(String player1, String player2) {
    String id = UUID.randomUUID().toString();
    TennisMatch match = new TennisMatch(player1, player2);
    activeMatches.put(id, match);

    TennisMatchDTO matchDto = new TennisMatchDTO();
    matchDto.setId(id);
    matchDto.setPlayer1(player1);
    matchDto.setPlayer2(player2);
    matchDto.setStatus(Status.IN_PROGRESS.toString());

    dbPort.upsertMatch(matchDto);
    return matchDto;
  }

  public TennisMatchDTO addPoint(String matchId, String player) {
    MatchResult currentResult = activeMatches.get(matchId).point(player);
    TennisMatchDTO matchDto = getMatchDto(matchId, currentResult);
    dbPort.upsertMatch(matchDto);

    if (currentResult.getMatchStatus() == Status.FINISHED) {
      queuePort.notifyMatchResult(matchDto);
      activeMatches.remove(matchId);
    }

    return matchDto;
  }

  private TennisMatchDTO getMatchDto(String matchId, MatchResult currentResult) {
    TennisMatchDTO matchDto = new TennisMatchDTO();
    matchDto.setId(matchId);
    matchDto.setPlayer1(currentResult.getPointsPlayer1().getPlayer());
    matchDto.setSetsPlayer1(currentResult.getPointsPlayer1().getSetsWon());
    matchDto.setPlayer2(currentResult.getPointsPlayer2().getPlayer());
    matchDto.setSetsPlayer2(currentResult.getPointsPlayer2().getSetsWon());
    matchDto.setStatus(currentResult.getMatchStatus().toString());
    return matchDto;
  }

  public void humidityChanged(HumidityDTO humidity) {
    if (humidity.getHumidityPercentage() > 10) {
      for (String matchId : activeMatches.keySet()) {
        dbPort.updateStatus(matchId, Status.SUSPENDED.toString());
      }
    }
    
    this.activeMatches.clear();
  }
}
