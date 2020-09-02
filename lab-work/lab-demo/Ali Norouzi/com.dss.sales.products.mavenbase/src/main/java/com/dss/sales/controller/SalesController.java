package com.dss.sales.controller;

import com.dss.sales.model.Products;
import com.dss.sales.model.Users;
import com.dss.sales.services.DataService;
import com.dss.sales.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SalesController {

    @Autowired
    private ProductsService service;
    @Autowired
    private DataService controllerOfData;

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
        String log = controllerOfData.findAndCheckUser(username,password);
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
        String check = controllerOfData.checkAndCreateUser(username,password);
        if (check.equals("Welcome")) {
            return "signupanswerT";
        }else{
            return "signupanswerF";
        }

    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
    @PostMapping("/cashincrease")
    public ModelAndView cashIncreased(@RequestParam("amount")long amount, @RequestParam("username")String username){
        Users userTemp = controllerOfData.findUserByUsername(username);
        controllerOfData.increaseWalletCash(amount,userTemp);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cashIncreased");
        modelAndView.addObject("user",userTemp);
        return modelAndView;
    }
    @PostMapping("/showallusers")
    public ModelAndView usersList(){
        List<Users> usersList = new ArrayList();
        usersList = controllerOfData.findAllUsers();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("allUsers");
        mv.addObject("usersList",usersList);
        return mv;
    }
    @PostMapping("/addOneUser")
    public String addOneUser(@RequestParam("username")String username,@RequestParam("password")String password){
        String log = controllerOfData.checkAndCreateUser(username,password);
        if (log.equals("Welcome")) {
            return "addOneUserAnswerT";
        }else{
            return "addOneUserAnswerF";
        }
    }
    @PostMapping("/showOneUser")
    public ModelAndView showOneUser(@RequestParam("username")String username){
        ModelAndView mv=new ModelAndView();
        Users user = controllerOfData.findUserByUsername(username);
        mv.setViewName("showOneUser");
        mv.addObject("user",user);
        return mv;
    }
    @PostMapping("/editOneUser") //This method is connected to "showOneUser" method
    public ModelAndView editOneUser(@RequestParam("id")long id,
                                    @RequestParam("password")String password,
                                    @RequestParam("username")String username,
                                    @RequestParam("phone_number")String phoneNumber,
                                    @RequestParam("wallet")long cash,
                                    @RequestParam("isMale")boolean isMale,
                                    @RequestParam("isFemale")boolean isFemale){
        ModelAndView mv = new ModelAndView();
        Users currentUser = controllerOfData.findUserById((int)id);
        Users updatedUser = new Users();
        updatedUser = currentUser;
        updatedUser.setPassword(password);
        updatedUser.setUsername(username);
        updatedUser.setWallet(cash);
        updatedUser.setFemale(isFemale);
        updatedUser.setMale(isMale);
        updatedUser.setPhoneNumber(phoneNumber);
        controllerOfData.editUser(updatedUser);
        mv.addObject("updatedUser",updatedUser);
        mv.setViewName("showEditedUser");
        return mv;
    }
    @PostMapping("/deleteOneUser")
    public String deleteOneUser(@RequestParam("id")int id){
        Users wantedUser = controllerOfData.findUserById(id);
        if(wantedUser!=null) {
            controllerOfData.deleteUser(wantedUser);
            return "deletedSuccessfully";
        }else {
            return "enteredIdDoesn'tExist";
        }
    }

}
