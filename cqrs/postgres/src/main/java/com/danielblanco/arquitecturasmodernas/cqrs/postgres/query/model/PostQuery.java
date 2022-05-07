package com.danielblanco.arquitecturasmodernas.cqrs.postgres.query.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post", schema = "cqrs")
public class PostQuery {

  @Id
  private Long id;
  private String content;
  @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<CommentQuery> comments;

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

  public List<CommentQuery> getComments() {
    return comments;
  }

  public void setComments(List<CommentQuery> comments) {
    this.comments = comments;
  }
}
