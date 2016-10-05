package ru.itis.inform.dao;

public class User {
  private int id;
  private String name;
  private int age;
  private String city;

  public User(int id, String name, int age, String city) {
    initUser(id, name, age, city);
  }

  private void initUser(int id, String name, int age, String city) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.city = city;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public String getCity() {
    return this.city;
  }
}
