package models;

public class Order {
  private int autoId;
  private String login;
  private String  supplierName;

  public Order(int autoId, String login, String supplierName) {
    this.autoId = autoId;
    this.login = login;
    this.supplierName = supplierName;
  }

  public int getAutoId() {
    return autoId;
  }

  public String getLogin() {
    return login;
  }

  public String getSupplierName() {
    return supplierName;
  }
}
