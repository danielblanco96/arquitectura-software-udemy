package com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.events.service;

import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.events.model.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

  Logger logger = LoggerFactory.getLogger(TransferService.class);

  @EventListener
  public void executeTransfer(Transfer transfer) {
    logger.debug("Transfer Event received. Sending " + transfer.getAmount() + " from " + transfer.getAccountIdFrom() + " to " + transfer.getAccountIdTo());
  }
}
