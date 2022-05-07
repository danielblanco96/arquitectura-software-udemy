package com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.service;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.CommentCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.PostCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.ReactionCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository.CommentCommandRepository;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository.PostCommandRepository;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository.ReactionCommandRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

  @Autowired
  PostCommandRepository postRepository;

  @Autowired
  CommentCommandRepository commentRepository;

  @Autowired
  ReactionCommandRepository reactionRepository;

  public PostCommand addPost(PostCommand post) {
    post.setLastModifiedDate(new Date());
    return postRepository.save(post);
  }

  public CommentCommand addComment(Long postId, CommentCommand comment) {
    comment.setPostId(postId);
    comment.setLastModifiedDate(new Date());
    return commentRepository.save(comment);
  }

  public ReactionCommand addReaction(Long postId, Long commentId, ReactionCommand reaction) {
    CommentCommand comment = new CommentCommand();
    comment.setId(commentId);
    reaction.setComment(comment);
    reaction.setLastModifiedDate(new Date());
    return reactionRepository.save(reaction);
  }
}
