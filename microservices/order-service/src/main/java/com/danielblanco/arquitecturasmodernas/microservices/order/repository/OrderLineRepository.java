package com.danielblanco.arquitecturasmodernas.microservices.order.repository;

import com.danielblanco.arquitecturasmodernas.microservices.order.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
