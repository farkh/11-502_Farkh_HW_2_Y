package models;

public class Supplier {
  private int id;
  private String name;
  private String surname;

  public Supplier(int id, String name, String surname) {
    this.id = id;
    this.name = name;
    this.surname = surname;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }
}
