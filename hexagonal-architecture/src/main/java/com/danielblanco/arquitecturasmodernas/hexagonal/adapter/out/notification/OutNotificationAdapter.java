package com.danielblanco.arquitecturasmodernas.hexagonal.adapter.out.notification;

import com.danielblanco.arquitecturasmodernas.hexagonal.application.dto.TennisMatchDTO;
import com.danielblanco.arquitecturasmodernas.hexagonal.port.out.notification.OutNotificationPort;
import org.springframework.stereotype.Service;

@Service
public class OutNotificationAdapter implements OutNotificationPort {

  @Override
  public void notifyMatchResult(TennisMatchDTO result) {
    // Send Message to AWS to notify that a match has ended
  }
}
