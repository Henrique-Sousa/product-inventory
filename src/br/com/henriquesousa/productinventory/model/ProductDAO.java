package br.com.henriquesousa.productinventory.model;

import java.sql.*;

public class ProductDAO extends DAO<Product> {

  public ProductDAO(Connection connection) {
    super(connection);
  }

  @Override
  public void save(Product product) throws SQLException {
    try {
      Statement statement = this.connection.createStatement();
      String query = "INSERT INTO products(name, description, price, quantity)" +
                     "values('" + product.name + "', '" + product.description + "'," + product.price + "," + product.quantity + ");";
      statement.executeUpdate(query);
    } catch(SQLException e) { 
      e.printStackTrace();
    }
  }

}
