package ru.itis.inform.models;

public class User {
  private String login;
  private String name;
  private String surname;
  private String address;
  private String phone;

  public User(String login, String name, String surname, String address, String phone) {
    this.login = login;
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.phone = phone;
  }

  public String getLogin() {
    return login;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }
}