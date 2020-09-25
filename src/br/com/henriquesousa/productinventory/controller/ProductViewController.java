package br.com.henriquesousa.productinventory.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import br.com.henriquesousa.productinventory.model.*;
import br.com.henriquesousa.productinventory.util.*;

@WebServlet("/product")
public class ProductViewController extends HttpServlet {

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
                Utils.forward("/product_view.jsp", request, response);
            }

        } catch(NumberFormatException e) {
            request.setAttribute("error", "Id must be an integer");
            Utils.forward("/error.jsp", request, response);
        } catch(SQLException e) {
            request.setAttribute("error", "Internal error");
            Utils.forward("/error.jsp", request, response);
        }

    }

}
