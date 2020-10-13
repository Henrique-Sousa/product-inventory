package br.com.henriquesousa.productinventory.model;

import java.sql.*;
import java.util.List;

public abstract class DAO<T> {

    protected final Connection connection;
    
    public DAO(Connection connection) {
        super();
        this.connection = connection;
    }

    public abstract T findById(long id) throws SQLException;
    public abstract List<T> findAll() throws SQLException;
    public abstract void save(T t) throws SQLException;
    public abstract void delete(long id) throws SQLException;
    public abstract void update(long id, T t) throws SQLException;
}

