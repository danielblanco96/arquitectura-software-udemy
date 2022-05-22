package com.danielblanco.arquitecturasmodernas.eventdrivenprogramming.functions.model;

public class Transfer {
  private String accountIdFrom;
  private String accountIdTo;
  private int amount;

  public String getAccountIdFrom() {
    return accountIdFrom;
  }

  public void setAccountIdFrom(String accountIdFrom) {
    this.accountIdFrom = accountIdFrom;
  }

  public String getAccountIdTo() {
    return accountIdTo;
  }

  public void setAccountIdTo(String accountIdTo) {
    this.accountIdTo = accountIdTo;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
