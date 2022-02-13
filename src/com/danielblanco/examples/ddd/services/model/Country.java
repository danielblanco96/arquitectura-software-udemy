package com.danielblanco.examples.ddd.services.model;

import java.time.LocalDate;

public class Country {
  private String name;
  private HealthQualityIndex healthQualityIndex;
  private LifeExpectancy lifeExpectancy;

  public Country(String name, double healthQualityIndexVal, double lifeExpectancyYears) {
    this.name = name;
    healthQualityIndex = new HealthQualityIndex(healthQualityIndexVal, LocalDate.now());
    lifeExpectancy = new LifeExpectancy(lifeExpectancyYears, LocalDate.now());
  }

  public double getLifeExpectancyYears() {
    return lifeExpectancy.getYears();
  }

  public double getHealthQualityIndexVal() {
    return healthQualityIndex.getValue();
  }
}
