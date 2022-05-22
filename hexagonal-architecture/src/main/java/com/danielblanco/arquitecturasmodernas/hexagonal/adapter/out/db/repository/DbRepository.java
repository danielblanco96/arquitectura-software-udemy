package com.danielblanco.arquitecturasmodernas.hexagonal.adapter.out.db.repository;

import com.danielblanco.arquitecturasmodernas.hexagonal.adapter.out.db.model.TennisMatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepository extends JpaRepository<TennisMatchEntity, String> {

}
