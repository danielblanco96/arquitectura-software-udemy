package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.reaction;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.Event;

public class ReactionRemovedEvent extends Event {

  private String reactionId;

  public String getReactionId() {
    return reactionId;
  }

  public void setReactionId(String reactionId) {
    this.reactionId = reactionId;
  }
}
