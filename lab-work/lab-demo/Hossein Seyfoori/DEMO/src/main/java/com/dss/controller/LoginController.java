package com.dss.controller;


import com.dss.dao.UserDao;

import com.dss.model.UserT;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.*;

import java.util.List;
import java.util.logging.Logger;

@Component
public class  LoginController extends BaseController   {


    private String message;

    @Autowired
    UserDao userDao ;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private UserRepository userRepository;

    Logger logger =  Logger.getLogger(String.valueOf(LoginController.class));
    @GetMapping()
    public ModelAndView loginShow(HttpSession session)
    {
        if(session.getAttribute("user_id") != null)
        {
             return new ModelAndView("redirect:/dashboard");
        }

        return new ModelAndView("login","message",message);
    }
    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(@RequestParam("email") String email,
                                   @RequestParam("password")String password,
                                   @RequestParam("g-recaptcha-response")String recaptchaResponse,
                                   HttpSession session
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

                session.setAttribute("user_id",userT.getId());

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
    public  ModelAndView dashboard(HttpSession session)
    {


        if(session.getAttribute("user_id") == null)
        {
            return new ModelAndView("login","message","لطفا لاگین کنید");
        }

        int user_id = 0;

        if(session.getAttribute("user_id") !=null)
        {
             user_id = (int) session.getAttribute("user_id");
        }


        ModelAndView mv = new ModelAndView("dashboard");

        List<UserT> all = userDao.findAllUsers();
        UserT userLogin = userDao.getUserById(user_id);
//      List<UserT> all = userRepository.findAll();

        mv.addObject("users",all);
        mv.addObject("user",userLogin);

        return mv;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/login")
    public ModelAndView login(HttpSession session)
    {

        if(session.getAttribute("user_id") != null)
        {
            return new ModelAndView("redirect:/dashboard");
        }

        session.invalidate();
        return new ModelAndView("login");
    }



}
