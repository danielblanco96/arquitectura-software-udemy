package com.danielblanco.arquitecturasmodernas.cqrs.postgres.query.service;

import com.danielblanco.arquitecturasmodernas.cqrs.postgres.query.model.PostQuery;
import com.danielblanco.arquitecturasmodernas.cqrs.postgres.query.repository.PostQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class QueryService {

  @Autowired
  private PostQueryRepository postRepository;

  public PostQuery getPost(Long id) {
    return postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND));
  }
}
