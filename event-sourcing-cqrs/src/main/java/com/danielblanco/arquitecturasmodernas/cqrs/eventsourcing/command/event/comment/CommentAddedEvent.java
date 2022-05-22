package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.comment;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.Event;

public class CommentAddedEvent extends Event {
  private String commentId;
  private String postId;
  private String content;

  public String getCommentId() {
    return commentId;
  }

  public void setCommentId(String commentId) {
    this.commentId = commentId;
  }

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
