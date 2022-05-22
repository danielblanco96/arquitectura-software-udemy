package com.danielblanco.arquitecturasmodernas.cqrs.advanced.sync.service;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.CommentCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.PostCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.ReactionCommand;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository.CommentCommandRepository;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository.PostCommandRepository;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository.ReactionCommandRepository;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.query.model.Comment;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.query.model.Post;
import com.danielblanco.arquitecturasmodernas.cqrs.advanced.query.model.Reaction;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SyncService {

  Date lastSyncDate = new Date();

  @Autowired
  PostCommandRepository postCommandRepository;

  @Autowired
  CommentCommandRepository commentCommandRepository;

  @Autowired
  ReactionCommandRepository reactionCommandRepository;

  @Autowired
  private MongoOperations mongoOps;

  public void sync() {
    Date newSyncDate = new Date();
    updatePosts();
    updateComments();
    updateReactions();
    lastSyncDate = newSyncDate;
  }

  private void updatePosts() {
    List<PostCommand> modifiedPosts = postCommandRepository.findAllByLastModifiedDateAfter(lastSyncDate);

    for(PostCommand post: modifiedPosts) {
      Query query = new Query(Criteria.where("id").is(post.getId().toString()));
      Update update = new Update();
      update.set("content", post.getContent());
      mongoOps.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), Post.class);
    }
  }

  private void updateComments() {
    List<CommentCommand> modifiedComments = commentCommandRepository.findAllByLastModifiedDateAfter(lastSyncDate);

    for(CommentCommand comment : modifiedComments) {
      Query query = new Query(Criteria.where("id").is(comment.getPostId().toString()));
      Update update = new Update();
      Comment mongoComment = new Comment();
      mongoComment.setId(comment.getId().toString());
      mongoComment.setContent(comment.getContent());
      update.addToSet("comments", mongoComment);
      mongoOps.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), Post.class);
    }
  }

  private void updateReactions() {
    List<ReactionCommand> modifiedReactions = reactionCommandRepository.findAllByLastModifiedDateAfter(lastSyncDate);

    for(ReactionCommand reaction : modifiedReactions) {
      Query query = new Query(new Criteria().andOperator(
          Criteria.where("id").is(reaction.getComment().getPostId().toString()),
          Criteria.where("comments").elemMatch(Criteria.where("id").is(reaction.getCommentId().toString()))
      ));
      Reaction mongoReaction = new Reaction();
      mongoReaction.setId(reaction.getId().toString());
      mongoReaction.setEmoji(reaction.getEmoji());
      Update update = new Update().addToSet("comments.$.reactions", mongoReaction);
      mongoOps.findAndModify(query, update, FindAndModifyOptions.options().upsert(true), Post.class);
    }
  }
}
