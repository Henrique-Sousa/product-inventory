package br.com.henriquesousa.productinventory.model;

import java.sql.*;

public class Product {
  private String name, description;
  private double price;
  private long quantity, id;
 
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return this.description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public double getPrice() {
    return this.price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public long getQuantity() {
    return this.quantity;
  }
  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }
}
