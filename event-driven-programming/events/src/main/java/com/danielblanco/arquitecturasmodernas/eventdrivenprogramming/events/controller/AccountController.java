package com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.events.controller;

import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.events.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  @PostMapping("/transfer")
  public void addTransfer(@RequestBody Transfer transfer) {
    applicationEventPublisher.publishEvent(transfer);
  }
}
