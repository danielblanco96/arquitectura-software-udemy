package com.danielblanco.examples.ddd.services.model;

public enum Severity {
  INSIGNIFICANT(0.01),
  LOW(0.05),
  MEDIUM(0.1),
  SEVERE(0.3),
  REALLY_SEVERE(0.5),
  MORTAL(0.95);

  private double effectPercentage;

  Severity(Double effect) {
    this.effectPercentage = effectPercentage;
  }

  public double getEffectPercentage() {
    return effectPercentage;
  }
}
