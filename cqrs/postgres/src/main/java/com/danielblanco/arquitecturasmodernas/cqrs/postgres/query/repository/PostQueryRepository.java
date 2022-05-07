package com.danielblanco.arquitecturasmodernas.cqrs.postgres.query.repository;

import com.danielblanco.arquitecturasmodernas.cqrs.postgres.query.model.PostQuery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostQueryRepository extends CrudRepository<PostQuery, Long> {

}
