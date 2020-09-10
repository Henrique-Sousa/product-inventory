package br.com.henriquesousa.productinventory.model;

public class Product {
  String name, description, id;
  double price;
  long quantity;
 
  public Product(String name, String description, double price, long quantity) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return this.description;
  }
  public void setDescription(String name) {
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
