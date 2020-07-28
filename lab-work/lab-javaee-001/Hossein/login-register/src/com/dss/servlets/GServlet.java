package com.dss.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "GServlet")
public class GServlet extends HttpServlet {

    public static HashMap<String,String> USERS = new HashMap<>();


}
