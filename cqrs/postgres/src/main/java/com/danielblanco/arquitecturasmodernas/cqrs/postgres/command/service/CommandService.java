package com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.service;

import com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.model.CommentCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.model.PostCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.model.ReactionCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.repository.CommentCommandRepository;
import com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.repository.PostCommandRepository;
import com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.repository.ReactionCommandRepository;
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
    return postRepository.save(post);
  }

  public CommentCommand addComment(Long postId, CommentCommand comment) {
    comment.setPostId(postId);
    return commentRepository.save(comment);
  }

  public ReactionCommand addReaction(Long postId, Long commentId, ReactionCommand reaction) {
    reaction.setCommentId(commentId);
    return reactionRepository.save(reaction);
  }
}
