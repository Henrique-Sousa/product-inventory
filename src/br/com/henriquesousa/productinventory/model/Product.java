package br.com.henriquesousa.productinventory.model;

import java.sql.*;

public class Product {
  String name, description;
  double price;
  long quantity, id;
 
  public Product(String name, String description, double price, long quantity) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public void save() throws SQLException {
    try {
      Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/productinventory", "productmanager", "123456");
      Statement statement = connection.createStatement();
      String query = "INSERT INTO products(name, description, price, quantity)" +
                     "values('" + this.name + "', '" + this.description + "'," + this.price + "," + this.quantity + ");";
      statement.executeUpdate(query);
      connection.close();
    } catch(SQLException e) { 
      e.printStackTrace();
    }
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
