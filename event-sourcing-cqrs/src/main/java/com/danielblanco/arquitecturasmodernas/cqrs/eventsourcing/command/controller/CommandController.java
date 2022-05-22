package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.controller;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.comment.CommentAddedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.comment.CommentRemovedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.comment.CommentUpdatedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.post.PostAddedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.post.PostRemovedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.post.PostUpdatedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.reaction.ReactionAddedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.reaction.ReactionRemovedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

  @Autowired
  private CommandService commandService;

  @PostMapping("/post")
  public PostAddedEvent addPost(@RequestBody PostAddedEvent post) {
    return commandService.addPost(post);
  }

  @PutMapping("/post")
  public PostUpdatedEvent updatePost(@RequestBody PostUpdatedEvent post) {
    return commandService.updatePost(post);
  }

  @DeleteMapping("/post/{postId}")
  public PostRemovedEvent removePost(@PathVariable String postId) {
    return commandService.removePost(postId);
  }

  @PostMapping("/post/{postId}/comment")
  public CommentAddedEvent addComment(@PathVariable String postId,
    @RequestBody CommentAddedEvent comment) {
    return commandService.addComment(postId, comment);
  }

  @PutMapping("/comment")
  public CommentUpdatedEvent updateComment(@RequestBody CommentUpdatedEvent comment) {
    return commandService.updateComment(comment);
  }

  @DeleteMapping("/comment/{commentId}")
  public CommentRemovedEvent removeComment(@PathVariable String commentId) {
    return commandService.removeComment(commentId);
  }

  @PostMapping("/post/{postId}/comment/{commentId}/reaction")
  public ReactionAddedEvent addReaction(@PathVariable String postId, @PathVariable String commentId,
    @RequestBody ReactionAddedEvent reaction) {
    return commandService.addReaction(postId, commentId, reaction);
  }

  @DeleteMapping("/reaction/{reactionId}")
  public ReactionRemovedEvent removeReaction(@PathVariable String reactionId) {
    return commandService.removeReaction(reactionId);
  }
}
