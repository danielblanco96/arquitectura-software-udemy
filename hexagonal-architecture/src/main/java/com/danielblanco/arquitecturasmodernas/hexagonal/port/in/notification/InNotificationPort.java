package com.danielblanco.arquitecturasmodernas.hexagonal.port.in.notification;

import com.danielblanco.arquitecturasmodernas.hexagonal.application.dto.HumidityDTO;

public interface InNotificationPort {

  void handleHumidityNotification(HumidityDTO humidity);
}
