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

            String sid = request.getParameter("id");
            Long id = Long.parseLong(sid);

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/productinventory", "productmanager", "123456");
            ProductDAO productDAO = new ProductDAO(connection);

            Product product = productDAO.findById(id); 

            connection.close();

            if (product == null) {
                RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            } else {
                //product.getId();
                //product.getName();
                //product.getDescription();
                //product.getPrice();
                //product.getQuantity();
                RequestDispatcher rd = request.getRequestDispatcher("/product_view.jsp");
                rd.forward(request, response);
            }

        } catch(SQLException e) {
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }
}
