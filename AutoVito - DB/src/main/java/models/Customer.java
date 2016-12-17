package models;

public class Customer {
  private int id;
  private String login;
  private String password;
  private String name;
  private String surname;
  private String city;
  private String street;
  private String house;
  private String phone;

  public Customer(int id, String login, String password, String name, String surname, String city, String street, String house, String phone) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.name = name;
    this.surname = surname;
    this.city = city;
    this.street = street;
    this.house = house;
    this.phone = phone;
  }

  public int getId() {
    return id;
  }

  public String getLogin() { return login; }

  public String getPassword() { return password; }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getCity() {
    return city;
  }

  public String getStreet() {
    return street;
  }

  public String getHouse() {
    return house;
  }

  public String getPhone() {
    return phone;
  }
}
