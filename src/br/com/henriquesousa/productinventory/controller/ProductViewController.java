package br.com.henriquesousa.productinventory.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import br.com.henriquesousa.productinventory.model.*;

@WebServlet("/product")
public class ProductViewController extends HttpServlet {

    public static void redirect(String path, HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {

            long id = 0;

            String sid = request.getParameter("id");

            if (sid != null) {
                id = Long.parseLong(sid);
            } else {
                redirect("/error.jsp", request, response);
            }

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/productinventory", "productmanager", "123456");
            ProductDAO productDAO = new ProductDAO(connection);

            Product product = productDAO.findById(id); 

            connection.close();

            if (product == null) {
                redirect("/error.jsp", request, response);
            } else {
                request.setAttribute("product", product);
                redirect("/product_view.jsp", request, response);
            }

        } catch(SQLException e) {
            redirect("/error.jsp", request, response);
        }
    }
}
