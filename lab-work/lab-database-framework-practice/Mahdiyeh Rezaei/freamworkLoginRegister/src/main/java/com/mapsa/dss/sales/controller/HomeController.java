package com.mapsa.dss.sales.controller;

import com.mapsa.dss.sales.database.CRUD;
import com.mapsa.dss.sales.database.DBConnection;
import com.mapsa.dss.sales.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {



    @RequestMapping("/home")
    public ModelAndView Home(){

        List<Person> personList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from persons");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                Person person = new Person();
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setPerson_id(resultSet.getInt("person_id"));
                personList.add(person);
            }


        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject(personList);

        return mv;
    }

//    @RequestMapping("/update")
//    public String UpdatePerson(){
//
//        Person person = new Person();
//        person.setPerson_id(1);
//        person.setFirstName("hosseinjoon");
//
//        CRUD crud = new CRUD();
//        try {
//            crud.update(person);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        return "update";
//
//    }
}
