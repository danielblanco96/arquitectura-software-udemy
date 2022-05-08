package com.danielblanco.arquitecturasmodernas.microservices.order.client;

import com.danielblanco.arquitecturasmodernas.microservices.order.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("product-service")
public interface ProductServiceClient {

  @PutMapping("/product-service/{productId}/{unitsToRemove}")
  ProductDTO removeStock(@PathVariable("productId") Long productId,
    @PathVariable("unitsToRemove") Integer unitsToRemove);
}
