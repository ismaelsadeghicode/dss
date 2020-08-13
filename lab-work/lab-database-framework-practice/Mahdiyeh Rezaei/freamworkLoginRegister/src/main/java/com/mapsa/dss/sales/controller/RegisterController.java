package com.mapsa.dss.sales.controller;

import com.mapsa.dss.sales.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class RegisterController {
    @PostMapping("/register")
    public ModelAndView registerPost(@RequestParam("username") String username, @RequestParam("password") String password,
                                    @RequestParam("ConfirmPassword") String confirmPassword){


        return AuthService.register(username, password, confirmPassword);
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }
 // login -> u == p
    // register -> p == p.c
}
