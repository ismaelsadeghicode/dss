package com.mapsa.dss.sales.service;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

public class AuthService {
    //check auth
    public static HashMap<String,String> USERS = new HashMap<>();

    public static ModelAndView register(String username,String password,String passwordConfirm){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("message");
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
}
