package br.com.henriquesousa.productinventory.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import br.com.henriquesousa.productinventory.model.*;
import br.com.henriquesousa.productinventory.util.*;

@WebServlet("/product/update")
public class ProductUpdateController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {

            String sid;
            long id;

            if ((sid = request.getParameter("id")) == null) {
                request.setAttribute("error", "No id found in the query string");
                Utils.forward("/error.jsp", request, response);
                return;
            } else {
                id = Long.parseLong(sid);
            }

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/productinventory", "productmanager", "123456");
            ProductDAO productDAO = new ProductDAO(connection);

            Product product = productDAO.findById(id); 

            connection.close();

            if (product == null) {
                request.setAttribute("error", "Product id not found on database");
                Utils.forward("/error.jsp", request, response);
            } else {
                request.setAttribute("product", product);
                Utils.forward("/product_update.jsp", request, response);
            }

        } catch(NumberFormatException e) {
            request.setAttribute("error", "Id must be an integer");
            Utils.forward("/error.jsp", request, response);
        } catch(SQLException e) {
            request.setAttribute("error", "Internal error");
            Utils.forward("/error.jsp", request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)

        throws ServletException, IOException {

        String sid, name, description;
        double price;
        long id, quantity;

        if ((sid = request.getParameter("id")) == null) {
            request.setAttribute("error", "No id found in the query string");
            Utils.forward("/error.jsp", request, response);
            return;
        } else {
            id = Long.parseLong(sid);
        }
        
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
            product.setId(id);

            //response.setContentType("text/html");
            //PrintWriter w = response.getWriter();
            //w.println(product.getName());
            //w.println(product.getDescription());
            //w.println(product.getId());

            productDAO.update(id, product);

            connection.close();

            response.sendRedirect(request.getContextPath() + "/products");
        
        } catch(SQLException e) {
            request.setAttribute("error", "Internal error");
            Utils.forward("/error.jsp", request, response);
        }
    }


    public static void main(String args[]) {
        System.out.println("main working");
    }
         

}
