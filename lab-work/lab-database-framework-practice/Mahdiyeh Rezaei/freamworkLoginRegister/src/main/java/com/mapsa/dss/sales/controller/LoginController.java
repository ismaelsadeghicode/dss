package com.mapsa.dss.sales.controller;

import com.mapsa.dss.sales.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

//    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginPost(@RequestParam("username") String username,@RequestParam("password") String password){
        return AuthService.login(username,password);
    }
}
