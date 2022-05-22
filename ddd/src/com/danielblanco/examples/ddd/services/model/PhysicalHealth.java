package com.danielblanco.examples.ddd.services.model;

public enum PhysicalHealth {
  LOW(0.0),
  NORMAL(0.1),
  HIGH(0.2);

  private double effectPercentage;

  PhysicalHealth(Double effectPercentage) {
    this.effectPercentage = effectPercentage;
  }

  public double getEffectPercentage() {
    return effectPercentage;
  }
}
