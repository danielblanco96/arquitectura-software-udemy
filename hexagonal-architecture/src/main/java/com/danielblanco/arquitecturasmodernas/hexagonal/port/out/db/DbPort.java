package com.danielblanco.arquitecturasmodernas.hexagonal.port.out.db;

import com.danielblanco.arquitecturasmodernas.hexagonal.application.dto.TennisMatchDTO;

public interface DbPort {

  void upsertMatch(TennisMatchDTO match);

  void updateStatus(String matchId, String status);

}
