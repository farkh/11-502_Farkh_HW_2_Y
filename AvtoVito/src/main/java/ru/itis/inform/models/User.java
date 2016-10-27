package ru.itis.inform.models;

public class User {
  private int id;
  private String login;
  private String password;
  private String fio;
  private String address;
  private String phone;

  public User(String login, String password, String fio, String address, String phone) {
    this.login = login;
    this.password = password;
    this.fio = fio;
    this.address = address;
    this.phone = phone;
    this.id = login.hashCode();
  }

  public User(String login) {
    this.login = login;
  }

  public int getId() { return id; }

  public String getLogin() {
    return login;
  }

  public String getPassword() { return password; }

  public String getFIO() {
    return fio;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }
}