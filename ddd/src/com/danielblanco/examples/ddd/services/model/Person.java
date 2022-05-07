package com.danielblanco.examples.ddd.services.model;

import java.util.List;

public class Person {
  private String name;
  private int yearsOfAge;
  private PhysicalHealth physicalHealth;
  private List<Disease> diseases;

  public double healthFactor() {
    double healthFactor = 1;
    for(Disease disease : diseases) {
      healthFactor -= disease.getSeverity().getEffectPercentage();
    }

    healthFactor += physicalHealth.getEffectPercentage();

    if(healthFactor < 0) return 0;
    if(healthFactor > 1) return 1;

    return healthFactor;
  }

  public int getYearsOfAge() {
    return yearsOfAge;
  }
}
