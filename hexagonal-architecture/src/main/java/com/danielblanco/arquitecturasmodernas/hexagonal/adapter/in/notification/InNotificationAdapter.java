package com.danielblanco.arquitecturasmodernas.hexagonal.adapter.in.notification;

import com.danielblanco.arquitecturasmodernas.hexagonal.application.TennisService;
import com.danielblanco.arquitecturasmodernas.hexagonal.application.dto.HumidityDTO;
import com.danielblanco.arquitecturasmodernas.hexagonal.port.in.notification.InNotificationPort;
import org.springframework.beans.factory.annotation.Autowired;

public class InNotificationAdapter implements InNotificationPort {

  @Autowired
  private TennisService tennisService;

  @Override
  public void handleHumidityNotification(HumidityDTO humidity) {
    tennisService.humidityChanged(humidity);
  }
}
