package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event;

import java.util.Date;
import java.util.UUID;

public class Event {

  private final UUID id = UUID.randomUUID();

  private final Date createdDate = new Date();

  public UUID getId() {
    return id;
  }

  public Date getCreatedDate() {
    return createdDate;
  }


}
