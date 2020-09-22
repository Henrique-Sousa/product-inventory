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

    @Override
    public Product findById(long id) throws SQLException {
        Product product = new Product();
        try {
            String query = "SELECT product_id, name, description, price, quantity FROM products WHERE product_id = ?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            product.setId(result.getLong("product_id"));
            product.setName(result.getString("name"));
            product.setDescription(result.getString("description"));
            product.setPrice(result.getDouble("price"));
            product.setQuantity(result.getLong("quantity"));
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return product;
    }

}
