package com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.model.CommentCommand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentCommandRepository extends CrudRepository<CommentCommand, Long> {

}
