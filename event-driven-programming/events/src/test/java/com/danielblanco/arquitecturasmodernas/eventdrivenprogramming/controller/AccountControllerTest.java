package com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.controller;

import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.events.controller.AccountController;
import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.events.model.Transfer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

  @Mock
  private ApplicationEventPublisher eventPublisher;
  @InjectMocks
  private AccountController accountController;

  @Test
  void givenAccountController_whenAddTransfer_thenCallServices() {
    Transfer transfer = new Transfer();
    accountController.addTransfer(transfer);
    Mockito.verify(eventPublisher, Mockito.times(1)).publishEvent(transfer);
  }
}
