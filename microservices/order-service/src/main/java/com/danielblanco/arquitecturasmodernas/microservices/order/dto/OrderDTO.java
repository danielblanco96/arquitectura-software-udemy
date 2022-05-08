package com.danielblanco.arquitecturasmodernas.microservices.order.dto;

import java.util.List;

public class OrderDTO {

  private Long userId;
  private List<OrderLineDTO> orderLines;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public List<OrderLineDTO> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(
    List<OrderLineDTO> orderLines) {
    this.orderLines = orderLines;
  }
}
