package com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.service;

import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.model.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

  Logger logger = LoggerFactory.getLogger(AlertService.class);
  private static final int ALERT_AMOUNT = 3000;

  public void sendAlertIfNeeded(Transfer transfer) {
    if (transfer.getAmount() > ALERT_AMOUNT) {
      logger.debug("Sending alert");
    } else {
      logger.debug("Alert not needed");
    }
  }
}
