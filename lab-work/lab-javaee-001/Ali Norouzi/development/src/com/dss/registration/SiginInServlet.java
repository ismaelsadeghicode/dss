package com.dss.registration;

import com.dss.database.UsersDatabase;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SiginInServlet",urlPatterns ="/signin" )
public class SiginInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        String checkResults = null;
        checkResults = UsersDatabase.checkAndSignIn(username,password);
        if(checkResults.equals("Welcome!")){
            out.println("<h1>Welcome</h1>");
        }else{
            out.println("<h1>"+checkResults+"</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
