package com.danielblanco.arquitecturasmodernas.cqrs.postgres.query.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comment", schema = "cqrs")
public class CommentQuery {

  @Id
  private Long id;
  private String content;
  @Column(name = "post_id")
  private Long postId;
  @OneToMany(mappedBy = "commentId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<ReactionQuery> reactions;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getPostId() {
    return postId;
  }

  public void setPostId(Long postId) {
    this.postId = postId;
  }

  public List<ReactionQuery> getReactions() {
    return reactions;
  }

  public void setReactions(List<ReactionQuery> reactions) {
    this.reactions = reactions;
  }
}
