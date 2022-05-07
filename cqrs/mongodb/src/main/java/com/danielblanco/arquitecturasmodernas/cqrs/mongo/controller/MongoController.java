package com.danielblanco.arquitecturasmodernas.cqrs.mongo.controller;

import com.danielblanco.arquitecturasmodernas.cqrs.mongo.model.Comment;
import com.danielblanco.arquitecturasmodernas.cqrs.mongo.model.Post;
import com.danielblanco.arquitecturasmodernas.cqrs.mongo.model.Reaction;
import com.danielblanco.arquitecturasmodernas.cqrs.mongo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {

  @Autowired
  private MongoService mongoService;

  @GetMapping("/post/{id}")
  public Post getPost(@PathVariable String id) {
    return mongoService.getPost(id);
  }

  @PostMapping("/post")
  public Post addPost(@RequestBody Post post) {
    return mongoService.addPost(post);
  }

  @PostMapping("/post/{postId}/comment")
  public Comment addComment(@PathVariable String postId, @RequestBody Comment comment) {
    return mongoService.addComment(postId, comment);
  }

  @PostMapping("/post/{postId}/comment/{commentId}/reaction")
  public Reaction addReaction(@PathVariable String postId, @PathVariable String commentId,
      @RequestBody Reaction reaction) {
    return mongoService.addReaction(postId, commentId, reaction);
  }
}
