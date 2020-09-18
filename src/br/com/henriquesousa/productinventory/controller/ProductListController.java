package br.com.henriquesousa.productinventory.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/products")
public class ProductListController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1> Product list placholder </h1>");
    }
}
