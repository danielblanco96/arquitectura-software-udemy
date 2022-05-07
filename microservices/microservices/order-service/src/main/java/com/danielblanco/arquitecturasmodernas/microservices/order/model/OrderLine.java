package com.danielblanco.arquitecturasmodernas.microservices.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "order_service")
public class OrderLine {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "product_id")
  private Long productId;
  @Column(name = "product_name")
  private String productName;
  @Column(name = "product_price")
  private Integer productPrice;
  private Integer quantity;
  @Column(name = "line_total_price")
  private Integer lineTotalPrice;
  @Column(name = "order_id")
  private Long orderId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getLineTotalPrice() {
    return lineTotalPrice;
  }

  public void setLineTotalPrice(Integer lineTotalPrice) {
    this.lineTotalPrice = lineTotalPrice;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
}
