package com.dss.sales.controller;

import com.dss.sales.model.Products;
import com.dss.sales.services.ProductsService;
import com.dss.sales.services.UsersDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@Controller
public class ControllerOfSales {

    @Autowired
    private ProductsService service;
    private UsersDatabase usersDatabase;

    @RequestMapping("/")
    public String homePage(){
        return "selection";
    }

    @RequestMapping("/sales")
    public ModelAndView SalesRightNow (){
        List<Products> products = service.ProductsService();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sales");
        mv.addObject("products",products);
        return mv;
    }

    @RequestMapping("/selection")
    public String selection(){ return "selection";}

    @GetMapping("signIn")
    public String SignIn(){
        return "signIn";
    }

    @PostMapping("/signIn")
    public String SignIn(@RequestParam("username")String username, @RequestParam("password") String password){
        String log = usersDatabase.checkAndSignIn(username,password);
        if(log.equals("Welcome!")){
            return "signinanswerT";
            }if(log.equals("Wrong password!")) {
            return "signinanswerFPassword";
                }if(log.equals("User doesn't exist")){
                    return "signinanswerFUser";
                }
        return "selection";
    }

    @GetMapping("/signUp")
    public String SignUp(){
        return "signUp";
    }
    @PostMapping("/signUp")
    public String signup(@RequestParam("username")String username, @RequestParam("password") String password){
        boolean check = usersDatabase.checkAndAddOne(username,password);
        if (check) {
            System.out.println("Welcome");
            return "signupanswerT";
        }else{
            System.out.println("User Exist!");
            return "signupanswerF";
        }

    }



}
