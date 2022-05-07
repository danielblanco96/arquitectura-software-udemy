package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.post;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.Event;

public class PostUpdatedEvent extends Event {

  private String postId;
  private String content;

  public String getPostId() {
    return postId;
  }

  public void setPostId(String postId) {
    this.postId = postId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
