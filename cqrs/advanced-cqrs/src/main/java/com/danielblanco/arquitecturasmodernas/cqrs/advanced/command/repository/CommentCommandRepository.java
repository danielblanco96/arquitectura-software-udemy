package com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.CommentCommand;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentCommandRepository extends CrudRepository<CommentCommand, Long> {

  List<CommentCommand> findAllByLastModifiedDateAfter(Date lastModifiedDate);
}
