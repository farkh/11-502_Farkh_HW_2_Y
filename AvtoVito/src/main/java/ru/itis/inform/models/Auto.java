package ru.itis.inform.models;

public class Auto {
  private String brand;
  private String type;
  private int mileage;
  private int horsepower;
  private String gearbox;
  private int year;
  private String color;
  private String wheel;

  public Auto(String brand, String type, int mileage, int horsepower, String gearbox, int year, String color, String wheel) {
    this.brand = brand;
    this.type = type;
    this.mileage = mileage;
    this.horsepower = horsepower;
    this.gearbox = gearbox;
    this.year = year;
    this.color = color;
    this.wheel = wheel;
  }

  public String getBrand() {
    return brand;
  }

  public String getType() {
    return type;
  }

  public int getMileage() {
    return mileage;
  }

  public int getHorsepower() {
    return horsepower;
  }

  public String getGearbox() {
    return gearbox;
  }

  public int getYear() {
    return year;
  }

  public String getColor() {
    return color;
  }

  public String getWheel() {
    return wheel;
  }
}