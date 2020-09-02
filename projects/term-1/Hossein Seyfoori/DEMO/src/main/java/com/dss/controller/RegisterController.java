package com.dss.controller;


import com.dss.dao.UserDao;
import com.dss.model.UserT;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    UserDao userDao ;

    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping("/register")
    public String registerShow()
    {
        return "register";
    }



    @RequestMapping("/registerCheck")
    public ModelAndView registerCheck(
            @RequestParam("username")String username,
            @RequestParam("email")String email,
            @RequestParam("first_name")String first_name,
            @RequestParam("last_name")String last_name,
            @RequestParam("password")String password,
            @RequestParam("password_confirm")String password_confirm)
    {

        UserT userByEmail = userDao.getUserByEmail(email);
        UserT userByUsername = userDao.getUserByUsername(username);
        ModelAndView mv = new ModelAndView();


           if(!username.equals("") )
           {
              if(!email.equals("")){
                  if(userByUsername == null && userByEmail == null  )
                  {
                      if(password.equals(password_confirm))
                      {
                          UserT userT1 = new UserT();
                          userT1.setUsername(username);
                          userT1.setEmail(email);
                          userT1.setFirst_name(first_name);
                          userT1.setLast_name(last_name);
                          userT1.setPassword(password);

                          userDao.insertUser(userT1);
                          mv.setViewName("redirect:/");
                      }else{
                          mv.addObject("message","اخ اخ دقت کن پسورد شبیه به هم وارد نکردی  فدای چشمای آبیت.");
                          mv.setViewName("register");

                      }
                  }else{
                      mv.addObject("used","نام کاربری یا ایمیل قبلا استفاده شده عشقم لطفا یکی دیگه انتخاب کن");
                      mv.setViewName("register");
                  }
              }else{
                  mv.addObject("exist","ایمیل  وارد نمایید.");
                  mv.setViewName("register");
              }
           }else{
               mv.addObject("exist","نام کاربری  وارد نمایید.");
               mv.setViewName("register");
           }


        return mv;

    }



}
