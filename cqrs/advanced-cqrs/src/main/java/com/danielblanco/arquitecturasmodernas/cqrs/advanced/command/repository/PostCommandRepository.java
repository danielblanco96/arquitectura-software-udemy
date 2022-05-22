package com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.advanced.command.model.PostCommand;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommandRepository extends CrudRepository<PostCommand, Long> {

  List<PostCommand> findAllByLastModifiedDateAfter(Date lastModifiedDate);
}
