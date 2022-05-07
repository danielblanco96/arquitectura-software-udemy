package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.comment;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.Event;

public class CommentRemovedEvent extends Event {
  private String commentId;

  public String getCommentId() {
    return commentId;
  }

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }
}
