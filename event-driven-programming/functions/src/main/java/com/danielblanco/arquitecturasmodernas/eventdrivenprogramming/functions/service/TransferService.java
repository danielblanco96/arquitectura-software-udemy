package com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.service;

import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.model.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

  Logger logger = LoggerFactory.getLogger(TransferService.class);

  public void executeTransfer(Transfer transfer) {
    logger.debug("Sending " + transfer.getAmount() + " from " + transfer.getAccountIdFrom() + " to " + transfer.getAccountIdTo());
  }
}
