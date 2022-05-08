package com.danielblanco.arquitecturasmodernas.microservices.order.repository;

import com.danielblanco.arquitecturasmodernas.microservices.order.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
