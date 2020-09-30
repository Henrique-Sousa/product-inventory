package br.com.henriquesousa.productinventory.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import br.com.henriquesousa.productinventory.model.*;
import br.com.henriquesousa.productinventory.util.*;

@WebServlet("/product/create")
public class ProductCreateController extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Utils.forward("/product_create.jsp", request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name, description;
        double price;
        long id, quantity;
        
        name = request.getParameter("name"); 
        if (name == "") {
            request.setAttribute("error", "Missing: name");
            Utils.forward("/error.jsp", request, response);
            return;
        }

        description = request.getParameter("description"); 
        if (description == "") {
            request.setAttribute("error", "Missing: description");
            Utils.forward("/error.jsp", request, response);
            return;
        }

        try {
            price = Double.parseDouble(request.getParameter("price"));
        } catch(NumberFormatException e) {
            request.setAttribute("error", "Missing: price");
            Utils.forward("/error.jsp", request, response);
            return;
        }

        try {
            quantity = Long.parseLong(request.getParameter("quantity"));
        } catch(NumberFormatException e) {
            request.setAttribute("error", "Missing: quantity");
            Utils.forward("/error.jsp", request, response);
            return;
        }

        try {

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/productinventory", "productmanager", "123456");
            ProductDAO productDAO = new ProductDAO(connection); 

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            productDAO.save(product);

            connection.close();

            response.sendRedirect(request.getContextPath() + "/products");
        
        } catch(SQLException e) {
            request.setAttribute("error", "Internal error");
            Utils.forward("/error.jsp", request, response);
        }

    }
}
