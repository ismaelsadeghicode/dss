package com.dss.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends GServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();


      if(USERS.containsKey(username))
      {
          if(USERS.get(username).equals(password))
          {
              response.sendRedirect("http://localhost:8080/loginRegister_war_exploded/welcome.html");
          }else{
              response.sendRedirect("http://localhost:8080/loginRegister_war_exploded/error.html");
          }
      }else{
          response.sendRedirect("http://localhost:8080/loginRegister_war_exploded/error.html");
      }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
