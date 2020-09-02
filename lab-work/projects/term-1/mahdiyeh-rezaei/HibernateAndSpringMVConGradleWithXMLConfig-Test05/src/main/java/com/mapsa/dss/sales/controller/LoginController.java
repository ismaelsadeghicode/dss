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
public class LoginController {
    @Autowired
    PersonDao personDao;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        Person personByUsername = personDao.getPersonByUsername(username);
        ModelAndView modelAndView = new ModelAndView("message");
        if (personByUsername != null) {
            if (password.equals(personByUsername.getPassword())) {
                modelAndView.addObject("msg", "You're Welcome!!");
            } else {
                modelAndView.addObject("msg", "Wrong Password >_<");
            }
        } else {
            modelAndView.addObject("msg", "Who are you??");
        }

        return modelAndView;
    }


}
