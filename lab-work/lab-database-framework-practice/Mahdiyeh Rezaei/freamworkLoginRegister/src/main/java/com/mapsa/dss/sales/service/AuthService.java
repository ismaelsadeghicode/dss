package com.mapsa.dss.sales.service;

import com.mapsa.dss.sales.database.CRUD;
import com.mapsa.dss.sales.database.DBConnection;
import com.mapsa.dss.sales.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

public class AuthService {
    public static HashMap<String,String> USERS = new HashMap<>();
    private static Connection connection ;
    private static DBConnection dbConnection = null;

    public static ModelAndView register(String username, String password, String passwordConfirm){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("message");

        try {
            dbConnection = DBConnection.getInstance();
            connection = dbConnection.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }






//      -------------------------------------------------
        if (USERS.containsKey(username)){
            //out.println("user exist.");
            modelAndView.addObject("msg","User Exist!!!");
        }else{
            if (password.equals(passwordConfirm)){
                USERS.put(username,password);
                //out.println("<h1>Done</h2>");
                modelAndView.addObject("msg","Done ^_^");

            }else{
                //out.println("Password not match.");
                modelAndView.addObject("msg","Password not match :(");
            }
        }
        return modelAndView;
    }
    public static ModelAndView login(String username,String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("message");
        if (USERS.containsKey(username)){
            if(USERS.get(username).equals(password)){
                modelAndView.addObject("msg","Welcome!! ");
            }else{
                modelAndView.addObject("msg","Wrong password ;(");
            }
        }else{
            modelAndView.addObject("msg","user not found! :(");
        }
        return modelAndView;

    }

    @RequestMapping("/update")
    public String UpdatePerson(){

        Person person = new Person();
        person.setPerson_id(1);
        person.setFirstName("hosseinjoon");

        CRUD crud = new CRUD();
        try {
            crud.update(person);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return "update";

    }


}
