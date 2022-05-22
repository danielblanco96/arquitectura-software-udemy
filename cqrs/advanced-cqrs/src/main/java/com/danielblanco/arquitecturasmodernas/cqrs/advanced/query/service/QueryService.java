package com.danielblanco.arquitecturasmodernas.cqrs.advanced.query.service;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.query.model.Post;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.query.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class QueryService {

  @Autowired
  PostRepository postRepository;

  public Post getPost(String id) {
    return postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
}
