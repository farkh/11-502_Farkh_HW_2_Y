package ru.itis.inform.dao;

public class Auto {
  private int id;
  private String name;

  public Auto(int id, String name) {
    initAuto(id, name);
  }

  private void initAuto(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return this.id + " " + this.name;
  }
}
