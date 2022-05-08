package com.danielblanco.arquitecturasmodernas.microservices.order.dto;

public class AddressDTO {

  private String firstLine;
  private String secondLine;
  private String country;
  private String postCode;
  private Boolean isDefault;

  public String getFirstLine() {
    return firstLine;
  }

  public void setFirstLine(String firstLine) {
    this.firstLine = firstLine;
  }

  public String getSecondLine() {
    return secondLine;
  }

  public void setSecondLine(String secondLine) {
    this.secondLine = secondLine;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public Boolean getDefault() {
    return isDefault;
  }

  public void setDefault(Boolean aDefault) {
    isDefault = aDefault;
  }
}
