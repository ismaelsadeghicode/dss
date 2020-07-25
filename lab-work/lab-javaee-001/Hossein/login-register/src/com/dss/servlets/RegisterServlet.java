package com.dss.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends GServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_confirm = request.getParameter("password-confirm");

        if(USERS.containsKey(username))
        {
            writer.println("User exist");
        }else{
            if(password.equals(password_confirm))
            {
                USERS.put(username,password);
            }else{
                writer.println("Password Not Match");

            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
