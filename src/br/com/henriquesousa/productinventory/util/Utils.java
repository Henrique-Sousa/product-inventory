package br.com.henriquesousa.productinventory.util;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Utils {

    public static void forward(String path, HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

}
