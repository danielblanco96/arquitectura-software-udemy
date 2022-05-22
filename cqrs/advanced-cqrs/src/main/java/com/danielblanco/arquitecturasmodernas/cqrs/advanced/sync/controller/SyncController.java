package com.danielblanco.arquitecturasmodernas.cqrs.advanced.sync.controller;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.sync.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SyncController {

  @Autowired
  private SyncService syncService;

  @PostMapping("/sync")
  public void sync() {
    syncService.sync();
  }
}
