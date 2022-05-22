package com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment_reaction", schema = "cqrs")
public class ReactionCommand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String emoji;
  @Column(name = "comment_id", insertable = false, updatable = false)
  private Long commentId;
  @ManyToOne
  private CommentCommand comment;
  private Date lastModifiedDate;

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

  public Date getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(Date lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public CommentCommand getComment() {
    return comment;
  }

  public void setComment(
      CommentCommand comment) {
    this.comment = comment;
  }
}
