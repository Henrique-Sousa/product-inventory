package br.com.henriquesousa.productinventory.model;

import java.sql.*;

public class ProductDAO extends DAO<Product> {

    public ProductDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void save(Product product) throws SQLException {
        String query = "INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setDouble(3, product.getPrice());
        statement.setLong(4, product.getQuantity());
        statement.execute();
    }

    @Override
    public Product findById(long id) throws SQLException {
        String query = "SELECT product_id, name, description, price, quantity FROM products WHERE product_id = ?";
        PreparedStatement statement = this.connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next() == false) {
            return null;
        } else {
            Product product = new Product();
            product.setId(result.getLong("product_id"));
            product.setName(result.getString("name"));
            product.setDescription(result.getString("description"));
            product.setPrice(result.getDouble("price"));
            product.setQuantity(result.getLong("quantity"));
            return product;
        }
    }

}
