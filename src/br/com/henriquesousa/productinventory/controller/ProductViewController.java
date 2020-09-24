package br.com.henriquesousa.productinventory.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import br.com.henriquesousa.productinventory.model.*;

@WebServlet("/product")
public class ProductViewController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {

            String sid;
            long id = 0;

            if ((sid = request.getParameter("id")) == null || sid == "") {
                request.setAttribute("error", "No id found in the query string");
                forward("/error.jsp", request, response);
            } else {
                id = Long.parseLong(sid);
            }

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/productinventory", "productmanager", "123456");
            ProductDAO productDAO = new ProductDAO(connection);

            Product product = productDAO.findById(id); 

            connection.close();

            if (product == null) {
                request.setAttribute("error", "Product id not found on database");
                forward("/error.jsp", request, response);
            } else {
                request.setAttribute("product", product);
                forward("/product_view.jsp", request, response);
            }

        } catch(SQLException e) {
            request.setAttribute("error", "Internal error");
            forward("/error.jsp", request, response);
        }
    }

    public static void forward(String path, HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

}
