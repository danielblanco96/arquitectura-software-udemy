package com.danielblanco.arquitecturasmodernas.microservices.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "order_service")
public class User {

  @Id
  private Long id;
  @Column(name = "full_name")
  private String fullName;
  @Column(name = "address_first_line")
  private String addressFirstLine;
  @Column(name = "address_second_line")
  private String addressSecondLine;
  @Column(name = "address_country")
  private String addressCountry;
  @Column(name = "address_post_code")
  private String addressPostCode;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
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
}
