package com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.postgres.command.model.ReactionCommand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionCommandRepository extends CrudRepository<ReactionCommand, Long> {

}
