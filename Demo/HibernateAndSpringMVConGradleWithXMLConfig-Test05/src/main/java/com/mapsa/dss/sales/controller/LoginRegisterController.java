package com.mapsa.dss.sales.controller;

import com.mapsa.dss.sales.dao.PersonDao;
import com.mapsa.dss.sales.model.Person;
import com.mapsa.dss.sales.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginRegisterController {
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

//        modelAndView.addObject("persons",person);
        return modelAndView;

//        List<Person> personList = personDao.findAllPersons();
//        ModelAndView modelAndView = new ModelAndView("person");
//        modelAndView.addObject("persons",personList);
//        return modelAndView;
//        ModelAndView register = AuthorizationService.register(username, password, password_confirm);
    }
}
