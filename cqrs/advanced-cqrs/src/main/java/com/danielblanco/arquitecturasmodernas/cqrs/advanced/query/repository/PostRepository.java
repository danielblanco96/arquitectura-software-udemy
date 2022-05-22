package com.danielblanco.arquitecturasmodernas.cqrs.advanced.query.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.query.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
