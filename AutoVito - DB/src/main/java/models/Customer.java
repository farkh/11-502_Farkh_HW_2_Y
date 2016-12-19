package models;

public class Customer {
  private String name;
  private String surname;
  private String city;
  private String street;
  private String house;
  private String phone;

  public Customer(String name, String surname, String city, String street, String house, String phone) {
    this.name = name;
    this.surname = surname;
    this.city = city;
    this.street = street;
    this.house = house;
    this.phone = phone;
  }

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
