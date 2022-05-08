package com.danielblanco.arquitecturasmodernas.hexagonal.port.out.notification;

import com.danielblanco.arquitecturasmodernas.hexagonal.application.dto.TennisMatchDTO;

public interface OutNotificationPort {

  void notifyMatchResult(TennisMatchDTO result);
}
