package com.danielblanco.arquitecturasmodernas.hexagonal.application.dto;

public class HumidityDTO {

  private final double humidityPercentage;

  public HumidityDTO(double humidityPercentage) {
    this.humidityPercentage = humidityPercentage;
  }

  public double getHumidityPercentage() {
    return humidityPercentage;
  }
}
