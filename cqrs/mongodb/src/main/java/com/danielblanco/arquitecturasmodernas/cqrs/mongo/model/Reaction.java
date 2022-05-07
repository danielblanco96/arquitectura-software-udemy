package com.danielblanco.arquitecturasmodernas.cqrs.mongo.model;

public class Reaction {

  private String id;
  private String emoji;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmoji() {
    return emoji;
  }

  public void setEmoji(String emoji) {
    this.emoji = emoji;
  }
}
