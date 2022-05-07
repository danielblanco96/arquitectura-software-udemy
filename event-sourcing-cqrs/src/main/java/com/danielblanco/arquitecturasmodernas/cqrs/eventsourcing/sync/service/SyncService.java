package com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.sync.service;

import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.Event;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.comment.CommentAddedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.comment.CommentRemovedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.comment.CommentUpdatedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.post.PostAddedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.post.PostRemovedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.post.PostUpdatedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.reaction.ReactionAddedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.event.reaction.ReactionRemovedEvent;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.command.repository.EventStore;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.query.model.Comment;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.query.model.Post;
import com.danielblanco.arquitecturasmodernas.cqrs.eventsourcing.query.repository.PostRepository;
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
  private EventStore eventStore;

  @Autowired
  private MongoOperations mongoOps;

  @Autowired
  private PostRepository postRepository;

  public void sync() {
    Date newSyncDate = new Date();
    List<Event> events = eventStore.getEventsAfterOrderAsc(newSyncDate);

    for (Event e : events) {
      if (e instanceof PostAddedEvent) {
        applyEvent((PostAddedEvent) e);
      } else if (e instanceof PostUpdatedEvent) {
        applyEvent((PostUpdatedEvent) e);
      } else if (e instanceof PostRemovedEvent) {
        applyEvent((PostRemovedEvent) e);
      } else if (e instanceof CommentAddedEvent) {
        applyEvent((CommentAddedEvent) e);
      } else if (e instanceof CommentUpdatedEvent) {
        applyEvent((CommentUpdatedEvent) e);
      } else if (e instanceof CommentRemovedEvent) {
        applyEvent((CommentRemovedEvent) e);
      } else if (e instanceof ReactionAddedEvent) {
        applyEvent((ReactionAddedEvent) e);
      } else if (e instanceof ReactionRemovedEvent) {
        applyEvent((ReactionRemovedEvent) e);
      }
    }

    lastSyncDate = newSyncDate;
  }

  private void applyEvent(PostAddedEvent event) {
    Post post = new Post();
    post.setId(event.getPostId());
    post.setContent(event.getContent());
    savePost(post);
  }

  private void applyEvent(PostUpdatedEvent event) {
    Post post = new Post();
    post.setId(event.getPostId());
    post.setContent(event.getContent());
    savePost(post);
  }

  private void applyEvent(PostRemovedEvent event) {
    postRepository.deleteById(event.getPostId());
  }

  private void applyEvent(CommentAddedEvent event) {
    Comment comment = new Comment();
    comment.setId(event.getCommentId());
    comment.setContent(event.getContent());
    saveComment(event.getPostId(), comment);
  }

  private void applyEvent(CommentUpdatedEvent event) {
    Comment comment = new Comment();
    comment.setId(event.getCommentId());
    comment.setContent(event.getContent());
    saveComment(event.getPostId(), comment);
  }

  private void applyEvent(CommentRemovedEvent event) {
    // Similar logic
  }

  private void applyEvent(ReactionAddedEvent event) {
    // Similar logic
  }

  private void applyEvent(ReactionRemovedEvent event) {
    // Similar logic
  }
  
  private void savePost(Post post) {
    Query query = new Query(Criteria.where("id").is(post.getId()));
    Update update = new Update();
    update.set("content", post.getContent());
    mongoOps.findAndModify(query, update,
      FindAndModifyOptions.options().returnNew(true).upsert(true), Post.class);
  }

  private void saveComment(String postId, Comment comment) {
    Query query = new Query(Criteria.where("id").is(postId));
    Update update = new Update();
    update.addToSet("comments", comment);
    mongoOps.findAndModify(query, update,
      FindAndModifyOptions.options().returnNew(true).upsert(true), Post.class);
  }
}
