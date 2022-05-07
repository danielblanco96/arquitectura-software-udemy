package com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.ReactionCommand;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionCommandRepository extends CrudRepository<ReactionCommand, Long> {

  List<ReactionCommand> findAllByLastModifiedDateAfter(Date lastModifiedDate);
}
