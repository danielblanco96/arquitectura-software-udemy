package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.query.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.query.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
