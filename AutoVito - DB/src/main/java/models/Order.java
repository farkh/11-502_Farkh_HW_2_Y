package models;

public class Order {
  private int id;
  private int autoId;
  private int customerId;
  private int supplierId;

  public Order(int id, int autoId, int customerId, int supplierId) {
    this.id = id;
    this.autoId = autoId;
    this.customerId = customerId;
    this.supplierId = supplierId;
  }

  public int getId() {
    return id;
  }

  public int getAutoId() {
    return autoId;
  }

  public int getCustomerId() {
    return customerId;
  }

  public int getSupplierId() {
    return supplierId;
  }
}
