package com.danielblanco.arquitecturasmodernas.cqrs.mongo.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.mongo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
