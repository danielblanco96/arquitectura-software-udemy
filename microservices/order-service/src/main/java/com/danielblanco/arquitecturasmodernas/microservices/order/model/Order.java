package com.danielblanco.arquitecturasmodernas.microservices.order.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "order_service")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "total_price")
  private Integer totalPrice;
  @Column(name = "order_date")
  private Date orderDate;
  @Column(name = "address_first_line")
  private String addressFirstLine;
  @Column(name = "address_second_line")
  private String addressSecondLine;
  @Column(name = "address_country")
  private String addressCountry;
  @Column(name = "address_post_code")
  private String addressPostCode;
  @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<OrderLine> orderLines;
  @ManyToOne
  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public String getAddressFirstLine() {
    return addressFirstLine;
  }

  public void setAddressFirstLine(String addressFirstLine) {
    this.addressFirstLine = addressFirstLine;
  }

  public String getAddressSecondLine() {
    return addressSecondLine;
  }

  public void setAddressSecondLine(String addressSecondLine) {
    this.addressSecondLine = addressSecondLine;
  }

  public String getAddressCountry() {
    return addressCountry;
  }

  public void setAddressCountry(String addressCountry) {
    this.addressCountry = addressCountry;
  }

  public String getAddressPostCode() {
    return addressPostCode;
  }

  public void setAddressPostCode(String addressPostCode) {
    this.addressPostCode = addressPostCode;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(
    List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
