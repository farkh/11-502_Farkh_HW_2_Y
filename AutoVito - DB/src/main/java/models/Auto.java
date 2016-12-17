package models;

public class Auto {
  private int id;
  private String brand;
  private String type;
  private int price;
  private String color;
  private String wheel;
  private int mileage;
  private int horsepower;
  private String gearbox;
  private int year;

  public Auto(int id, String brand, String type, int price, String color, String wheel, int mileage, int horsepower, String gearbox, int year) {
    this.id = id;
    this.brand = brand;
    this.type = type;
    this.price = price;
    this.color = color;
    this.wheel = wheel;
    this.mileage = mileage;
    this.horsepower = horsepower;
    this.gearbox = gearbox;
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getType() {
    return type;
  }

  public int getPrice() {
    return price;
  }

  public String getColor() {
    return color;
  }

  public String getWheel() {
    return wheel;
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
}
