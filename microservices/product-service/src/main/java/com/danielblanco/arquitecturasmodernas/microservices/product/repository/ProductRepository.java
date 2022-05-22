package com.danielblanco.arquitecturasmodernas.microservices.product.repository;

import com.danielblanco.arquitecturasmodernas.microservices.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
