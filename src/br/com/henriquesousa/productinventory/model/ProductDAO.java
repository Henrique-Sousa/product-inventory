package br.com.henriquesousa.productinventory.model;

import java.sql.*;

public class ProductDAO extends DAO<Product> {

  public ProductDAO(Connection connection) {
    super(connection);
  }

  @Override
  public void save(Product product) throws SQLException {
    try {
      String query = "INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)";
      PreparedStatement statement = this.connection.prepareStatement(query);
      statement.setString(1, product.getName());
      statement.setString(2, product.getDescription());
      statement.setDouble(3, product.getPrice());
      statement.setLong(4, product.getQuantity());
      statement.execute();
    } catch(SQLException e) { 
      e.printStackTrace();
    }
  }

}
