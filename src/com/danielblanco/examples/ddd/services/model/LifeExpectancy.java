package com.danielblanco.examples.ddd.services.model;

import java.time.LocalDate;

public class LifeExpectancy {
  private double years;
  private LocalDate yearOfMeasurement;

  public LifeExpectancy(double years, LocalDate yearOfMeasurement) {
    if(years < 0) throw new IllegalArgumentException();

    this.years = years;
    this.yearOfMeasurement = yearOfMeasurement;
  }

  public double getYears() {
    return years;
  }

  public LocalDate getYearOfMeasurement() {
    return yearOfMeasurement;
  }
}
