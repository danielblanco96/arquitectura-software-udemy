package com.danielblanco.examples.ddd.services.model;

import java.time.LocalDate;

public class HealthQualityIndex {
  private double value;
  private LocalDate yearOfMeasurement;

  public HealthQualityIndex(double value, LocalDate yearOfMeasurement) {
    if(value < 0 || value > 1) throw new IllegalArgumentException();

    this.value = value;
    this.yearOfMeasurement = yearOfMeasurement;
  }

  public double getValue() {
    return value;
  }

  public LocalDate getYearOfMeasurement() {
    return yearOfMeasurement;
  }
}
