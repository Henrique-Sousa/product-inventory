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

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        try {
            id = Long.parseLong(request.getParameter("id"));
            out.println(id);
        } catch(NumberFormatException e) {
            request.setAttribute("error", "Missing: id");
            Utils.forward("/error.jsp", request, response);
            return;
        }

        name = request.getParameter("name"); 
        if (name != "") {
            out.println(name);
        } else {
            request.setAttribute("error", "Missing: name");
            Utils.forward("/error.jsp", request, response);
            return;
        }

        description = request.getParameter("description"); 
        if (description != "") {
            out.println(description);
        } else {
            request.setAttribute("error", "Missing: description");
            Utils.forward("/error.jsp", request, response);
            return;
        }

        try {
            price = Double.parseDouble(request.getParameter("price"));
            out.println(price);
        } catch(NumberFormatException e) {
            request.setAttribute("error", "Missing: price");
            Utils.forward("/error.jsp", request, response);
            return;
        }

        try {
            quantity = Long.parseLong(request.getParameter("quantity"));
            out.println(quantity);
        } catch(NumberFormatException e) {
            request.setAttribute("error", "Missing: quantity");
            Utils.forward("/error.jsp", request, response);
            return;
        }

    }
}
