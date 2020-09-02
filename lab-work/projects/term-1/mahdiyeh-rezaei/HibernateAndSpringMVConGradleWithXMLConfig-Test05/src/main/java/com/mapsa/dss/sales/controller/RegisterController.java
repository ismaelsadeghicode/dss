package com.mapsa.dss.sales.controller;

import com.mapsa.dss.sales.dao.PersonDao;
import com.mapsa.dss.sales.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class RegisterController {

    @Autowired
    PersonDao personDao;


    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("password_confirm") String password_confirm) {
        Person person = new Person();
        person.setUsername(username);
        person.setPassword(password);
        Person personByUsername = personDao.getPersonByUsername(username);
        ModelAndView modelAndView = new ModelAndView("message");
        if (personByUsername == null) {
            if (password.equals(password_confirm)) {
                personDao.insertPerson(person);
                modelAndView.addObject("msg", "user added!");
            } else {
                modelAndView.addObject("msg", "password != password confirm :(");
            }
        } else {
            modelAndView.addObject("msg", "Are you kidding me? User exist.");
        }
        return modelAndView;
    }
}
