package ru.itis.inform.models;

public class Auto {
  private int auto_id;
  private String brand;
  private String type;
  private String mileage;
  private String horsepower;
  private String gearbox;
  private String year;
  private String color;
  private String wheel;
  private String price;

  public Auto(String brand, String type, String mileage, String horsepower, String gearbox, String year, String color, String wheel) {
    this.auto_id = brand.hashCode();
    this.brand = brand;
    this.type = type;
    this.mileage = mileage;
    this.horsepower = horsepower;
    this.gearbox = gearbox;
    this.year = year;
    this.color = color;
    this.wheel = wheel;
  }

  public Auto(String brand, String type, String mileage, String horsepower, String gearbox, String year, String color, String wheel, String price) {
    this.auto_id = brand.hashCode();
    this.brand = brand;
    this.type = type;
    this.mileage = mileage;
    this.horsepower = horsepower;
    this.gearbox = gearbox;
    this.year = year;
    this.color = color;
    this.wheel = wheel;
    this.price = price;
  }

  public int getId() { return auto_id; }

  public String getBrand() {
    return brand;
  }

  public String getType() {
    return type;
  }

  public String getMileage() {
    return mileage;
  }

  public String getHorsepower() {
    return horsepower;
  }

  public String getGearbox() {
    return gearbox;
  }

  public String getYear() {
    return year;
  }

  public String getColor() {
    return color;
  }

  public String getWheel() {
    return wheel;
  }

  public String getPrice() { return price; }
}