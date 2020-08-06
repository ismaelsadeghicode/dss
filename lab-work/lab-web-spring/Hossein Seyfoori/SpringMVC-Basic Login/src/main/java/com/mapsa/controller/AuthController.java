package com.mapsa.controller;


import com.mapsa.service.GService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthController {


    @PostMapping("/login")
    public ModelAndView loginPost(@RequestParam("username") String username,@RequestParam("password") String password)
    {
        ModelAndView mv = new ModelAndView();

        GService.USER.put("fqx","123");

        if(username.equals("") && password.equals("")){
            mv.setViewName("error");
            mv.addObject("error","Wrong INPUT!");
        }

        if(GService.USER.containsKey(username))
        {
            if(GService.USER.get(username).equals(password))
            {
                mv.setViewName("error");
                mv.addObject("error","Welcome!");
            }else{
                mv.setViewName("error");
                mv.addObject("error","Password Wrong!");
            }
        }else{
            mv.setViewName("error");
            mv.addObject("error","Username Doesn't Exist");
        }
        return mv;
    }

    @GetMapping("/login")
    public String loginGet(){
        return "loginAndRegister";
    }

    @PostMapping("/register")
    public ModelAndView register(HttpServletResponse response,
            @RequestParam("r_username") String username,@RequestParam("r_password") String password,@RequestParam("r_password_confirm") String password_confirm) throws IOException {
        ModelAndView mv = new ModelAndView();


        if(username.equals("") && password.equals("")){
            mv.setViewName("error");
            mv.addObject("error","Wrong INPUT!");
        }


        mv.setViewName("loginAndRegister");

        if(GService.USER.containsKey(username))
        {
            mv.setViewName("error");
            mv.addObject("error","Sorry ! Username Exist");
        }else{
            if(password.equals(password_confirm))
            {
                GService.USER.put(username,password);
                response.sendRedirect("/login");
            }else{
                mv.setViewName("error");
                mv.addObject("error","Sorry ! Password Not Match");

            }
        }



        return mv;
    }

}
