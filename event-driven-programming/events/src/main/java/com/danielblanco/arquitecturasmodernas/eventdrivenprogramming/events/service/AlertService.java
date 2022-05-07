package com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.events.service;

import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.events.model.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

  Logger logger = LoggerFactory.getLogger(AlertService.class);
  private static final int ALERT_AMOUNT = 3000;

  @EventListener
  public void sendAlertIfNeeded(Transfer transfer) throws InterruptedException {
    Thread.sleep(3000);
    if (transfer.getAmount() > ALERT_AMOUNT) {
      logger.debug("Transfer Event received. Sending alert");
    } else {
      logger.debug("Transfer Event received. Alert not needed");
    }
  }
}
