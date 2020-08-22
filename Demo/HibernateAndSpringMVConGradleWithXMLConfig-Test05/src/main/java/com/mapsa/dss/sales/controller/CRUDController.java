package com.mapsa.dss.sales.controller;

import com.mapsa.dss.sales.dao.PersonDao;
import com.mapsa.dss.sales.dao.ProductDAO;
import com.mapsa.dss.sales.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CRUDController {
    //create=postLogin, Read, Update, Delete
    private ModelAndView modelAndView = new ModelAndView();
    @Autowired
    ProductDAO productDAO;
    @Autowired
    PersonDao personDao;

    //person
    //read
    @GetMapping("/personlist")
    public ModelAndView showPersonList() {
        personDao.findAllPersons();
        List<Person> personList = personDao.findAllPersons();
//        ModelAndView modelAndView = new ModelAndView("person");
        modelAndView.setViewName("person");
        modelAndView.addObject("persons", personList);
        return modelAndView;
    }

    //delete
    @GetMapping("/deleteperson")
    public String deleteperson() {
        return "delete";
    }

    @PostMapping("/deleteperson")
    public ModelAndView deletePerson(@RequestParam("username") String username) {
        Person personByUsername = personDao.getPersonByUsername(username);
        if (personByUsername != null) {
            personDao.deletePerson(personByUsername);
            modelAndView.setViewName("message");
            modelAndView.addObject("msg", "X Deleted X");
        } else {
            modelAndView.addObject("msg", "User not found!");
        }
        return modelAndView;
    }

    //update
    @GetMapping("/updateperson")
    public String updatePerson() {
        return "update";
    }

    @PostMapping("/updateperson")
    public ModelAndView updatePerson(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("password_confirm") String password_confirm) {
        modelAndView.setViewName("message");
        Person personByUsername = personDao.getPersonByUsername(username);
        if (personByUsername != null) {
            if (password.equals(password_confirm)) {
                personByUsername.setPassword(password);
                personDao.updatePerson(personByUsername);
                modelAndView.addObject("msg", "* updated *");
            } else {
                modelAndView.addObject("msg", "password != password confirm :(");
            }
        } else {
            modelAndView.addObject("msg", "User not found!");
        }
        return modelAndView;
    }
}
