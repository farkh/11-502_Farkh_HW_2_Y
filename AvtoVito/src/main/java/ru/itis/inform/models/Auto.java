package ru.itis.inform.models;

public class Auto {
  private String brand;
  private String photoLink;
  private String id;



  public Auto(String brand, String photoLink) {
    this.brand = brand;
    this.photoLink = photoLink;
  }

  public Auto(String id, String brand, String photoLink) {
    this.id = id;
    this.brand = brand;
    this.photoLink = photoLink;
  }

  public String getId() { return id; }

  public String getBrand() {
    return brand;
  }

  public String getPhotoLink() {
    return photoLink;
  }
}