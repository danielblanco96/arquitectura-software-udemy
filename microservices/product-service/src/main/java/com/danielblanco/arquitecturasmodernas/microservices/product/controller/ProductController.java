package com.danielblanco.arquitecturasmodernas.microservices.product.controller;

import com.danielblanco.arquitecturasmodernas.microservices.product.exception.InsufficientStockException;
import com.danielblanco.arquitecturasmodernas.microservices.product.exception.ProductNotFoundException;
import com.danielblanco.arquitecturasmodernas.microservices.product.model.Product;
import com.danielblanco.arquitecturasmodernas.microservices.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/{id}")
  public Product findById(@PathVariable Long id) {
    return productService.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/")
  public List<Product> findAll() {
    return productService.findAll();
  }

  @PutMapping("/{id}/{unitsToRemove}")
  public Product updateStock(@PathVariable Long id, @PathVariable int unitsToRemove) {
    try {
      return productService.removeStock(id, unitsToRemove);
    } catch (ProductNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } catch (InsufficientStockException e) {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN,
        "Insufficient Stock for product with id=" + id);
    }

  }
}
