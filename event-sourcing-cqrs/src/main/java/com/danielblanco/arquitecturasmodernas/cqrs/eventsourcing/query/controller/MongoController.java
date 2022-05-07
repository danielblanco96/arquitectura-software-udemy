package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.query.controller;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.query.model.Post;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {

  @Autowired
  private QueryService queryService;

  @GetMapping("/post/{id}")
  public Post getPost(@PathVariable String id) {
    return queryService.getPost(id);
  }
}
