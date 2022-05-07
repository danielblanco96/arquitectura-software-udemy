package com.danielblanco.arquitecturasmodernas.microservices.order.dto;

public class OrderLineDTO {

  private Long productId;
  private Integer quantity;

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
