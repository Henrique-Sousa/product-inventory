package br.com.henriquesousa.productinventory.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import br.com.henriquesousa.productinventory.model.ProductDAO;
import br.com.henriquesousa.productinventory.util.*;
import java.sql.*;
import java.util.*;

@WebServlet("/products")
public class ProductListController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/productinventory", "productmanager", "123456");
            ProductDAO productDAO = new ProductDAO(connection);
            List products = productDAO.findAll();
            request.setAttribute("products", products);
            Utils.forward("/product_list.jsp", request, response);
        } catch (SQLException e) {
            request.setAttribute("error", "Internal error");
            Utils.forward("/error.jsp", request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        this.doGet(request, response);
    }
}
