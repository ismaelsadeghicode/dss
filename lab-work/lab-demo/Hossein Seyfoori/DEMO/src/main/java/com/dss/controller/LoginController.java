package com.dss.controller;


import com.dss.dao.UserDao;
import com.dss.model.RecaptchaResponse;
import com.dss.model.UserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class LoginController {


    private String message;

    @Autowired
    UserDao userDao ;

    @Autowired
    private RestTemplate restTemplate;

    Logger logger =  Logger.getLogger(String.valueOf(LoginController.class));
    @GetMapping("/")
    public ModelAndView loginShow()
    {
        return new ModelAndView("login","message",message);
    }
    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(@RequestParam("email") String email,
                                   @RequestParam("password")String password,
                                   @RequestParam("g-recaptcha-response")String recaptchaResponse
                                   )
    {

//        String url = "https://www.google.com/recaptcha/api/siteverify";
//        String params = "?secret=6Le8xMEZAAAAAEmekuqL4zsmUAyyduG7zXn98mR&response="+recaptchaResponse;
//
//
//
//        RecaptchaResponse recaptcha_response = restTemplate.exchange(url+params, HttpMethod.POST,null,RecaptchaResponse.class).getBody();
//        if(!recaptcha_response.isSuccess())
//        {
//            return new ModelAndView("login","message","کپچا رو چک نزدی فدات شم");
//        }

        ModelAndView mv = new ModelAndView();
        UserT userT = userDao.getUserByEmail(email);

        if(userT !=null)
        {
            if(password.equals(userT.getPassword()))
            {
                mv.setViewName("redirect:/dashboard");

            }else{
                mv.addObject("message","آخ پسورد اشتباه زدی فدات شم.");
                mv.setViewName("login");
            }
        }else{
            mv.addObject("message","یوزر پیدا نشد عزیزم.");
           mv.setViewName("login");
        }

        return mv;
    }

    @RequestMapping("/error")
    public String error()
    {
        return "404";
    }

    @RequestMapping("/dashboard")
    public  ModelAndView dashboard()
    {
        ModelAndView mv = new ModelAndView("dashboard");

        List<UserT> allUsers = userDao.findAllUsers();

        mv.addObject("users",allUsers);

        return mv;
    }



}
