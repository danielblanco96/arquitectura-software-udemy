package com.danielblanco.arquitecturasmodernas.microservices.order.repository;

import com.danielblanco.arquitecturasmodernas.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
