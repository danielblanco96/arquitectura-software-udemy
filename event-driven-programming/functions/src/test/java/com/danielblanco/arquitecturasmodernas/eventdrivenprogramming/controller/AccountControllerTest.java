package com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.controller;

import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.controller.AccountController;
import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.model.Transfer;
import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.service.AlertService;
import com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.service.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

  @Mock
  private TransferService transferService;

  @Mock
  private AlertService alertService;

  @InjectMocks
  private AccountController accountController;

  @Test
  void givenAccountController_whenAddTransfer_thenCallServices() {
    Transfer transfer = new Transfer();
    accountController.addTransfer(transfer);
    Mockito.verify(transferService, Mockito.times(1)).executeTransfer(transfer);
    Mockito.verify(alertService, Mockito.times(1)).sendAlertIfNeeded(transfer);
  }
}
