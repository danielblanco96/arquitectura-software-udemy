package com.danielblanco.arquitecturasmodernas.microservices.order.dto;

import java.util.List;

public class UserDTO {

  private Long id;
  private String fullName;
  private List<AddressDTO> addresses;

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

  public List<AddressDTO> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<AddressDTO> addresses) {
    this.addresses = addresses;
  }
}
