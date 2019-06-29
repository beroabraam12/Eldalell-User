package com.project.eldalell.user.Classes;

public class History {

  private String OrderName, OrderID, OrderDate;
  private boolean OrderStatus;

  public History(String OrderName, boolean OrderStatus, String OrderID, String OrderDate) {
    this.OrderName = OrderName;
    this.OrderStatus = OrderStatus;
    this.OrderID = OrderID;
    this.OrderDate = OrderDate;

  }

  public History() {
  }


  public String getOrderName() {
    return OrderName;
  }

  public void setOrderName(String OrderName) {
    this.OrderName = OrderName;
  }


  public String getOrderDate() {
    return OrderDate;
  }

  public void setOrderDate(String OrderDate) {
    this.OrderDate = OrderDate;
  }


  public String getOrderID() {
    return OrderID;
  }

  public void setOrderID(String OrderID) {
    this.OrderID = OrderID;
  }


  public boolean isOrderStatus() {
    return OrderStatus;
  }

  public void setOrderStatus(boolean orderStatus) {
    OrderStatus = orderStatus;
  }
}
