package com.danielblanco.arquitecturasmodernas.cqrs.mongo.model;

import java.util.List;

public class Comment {

  private String id;
  private String content;
  private List<Reaction> reactions;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<Reaction> getReactions() {
    return reactions;
  }

  public void setReactions(List<Reaction> reactions) {
    this.reactions = reactions;
  }
}
