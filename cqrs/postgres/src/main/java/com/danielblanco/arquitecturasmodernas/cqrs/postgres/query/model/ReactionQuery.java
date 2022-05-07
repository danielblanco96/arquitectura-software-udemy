package com.danielblanco.arquitecturasmodernas.cqrs.postgres.query.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment_reaction", schema = "cqrs")
public class ReactionQuery {

  @Id
  private Long id;
  private String emoji;
  @Column(name = "comment_id")
  private Long commentId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmoji() {
    return emoji;
  }

  public void setEmoji(String emoji) {
    this.emoji = emoji;
  }

  public Long getCommentId() {
    return commentId;
  }

  public void setCommentId(Long commentId) {
    this.commentId = commentId;
  }
}
