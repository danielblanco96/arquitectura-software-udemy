package com.danielblanco.arquitecturasmodernas.cqrs.mongo.service;

import com.danielblanco.arquitecturasmodernas.cqrs.mongo.model.Comment;
import com.danielblanco.arquitecturasmodernas.cqrs.mongo.model.Post;
import com.danielblanco.arquitecturasmodernas.cqrs.mongo.model.Reaction;
import com.danielblanco.arquitecturasmodernas.cqrs.mongo.repository.PostRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MongoService {

  @Autowired
  PostRepository postRepository;

  @Autowired
  private MongoOperations mongoOps;

  public Post getPost(String id) {
    return postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  public Comment addComment(String postId, Comment comment) {
    comment.setId(UUID.randomUUID().toString());
    Update update = new Update();
    Query query = new Query();
    query.addCriteria((Criteria.where("id").is((postId))));
    update.addToSet("comments", comment);
    mongoOps.findAndModify(query, update, FindAndModifyOptions.options().upsert(false), Post.class);
    return comment;
  }

  public Post addPost(Post post) {
    return postRepository.save(post);
  }

  public Reaction addReaction(String postId, String commentId, Reaction reaction) {
    reaction.setId(UUID.randomUUID().toString());
    Query query = new Query(new Criteria().andOperator(
        Criteria.where("id").is(postId),
        Criteria.where("comments").elemMatch(Criteria.where("id").is(commentId))
    ));
    Update update = new Update().addToSet("comments.$.reactions", reaction);
    mongoOps.findAndModify(query, update, FindAndModifyOptions.options().upsert(false), Post.class);
    return reaction;
  }
}
