package com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.controller;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.CommentCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.PostCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.ReactionCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

  @Autowired
  private CommandService commandService;

  @PostMapping("/post")
  public PostCommand addPost(@RequestBody PostCommand post) {
    return commandService.addPost(post);
  }

  @PostMapping("/post/{postId}/comment")
  public CommentCommand addComment(@PathVariable Long postId, @RequestBody CommentCommand comment) {
    return commandService.addComment(postId, comment);
  }

  @PostMapping("/post/{postId}/comment/{commentId}/reaction")
  public ReactionCommand addReaction(@PathVariable Long postId, @PathVariable Long commentId,
      @RequestBody ReactionCommand reaction) {
    return commandService.addReaction(postId, commentId, reaction);
  }
}
