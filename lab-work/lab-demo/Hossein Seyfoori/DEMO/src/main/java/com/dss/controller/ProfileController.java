package com.dss.controller;

import com.dss.dao.UserDao;
import com.dss.model.UserT;
import com.dss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Contended;

import java.util.logging.Logger;

@Controller
public class ProfileController {

    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;


    Logger logger = Logger.getLogger(String.valueOf(ProfileController.class));
    @RequestMapping("/profile/{id}/edit")
    public ModelAndView edit(@PathVariable("id") int id)
    {
        UserT userById = userDao.getUserById(id);
        return new ModelAndView("profile-edit","user",userById);

    }


    @PostMapping("/profile/update")
    public ModelAndView profileUpdate(@RequestParam("id") int id,
                             @RequestParam("phone_number")String phone_number,
                             @RequestParam("email")String email,
                             @RequestParam("first_name")String first_name,
                             @RequestParam("last_name")String last_name

         ){

        UserT user = userService.getUserById(id, phone_number, email, first_name, last_name);


        userDao.updateUser(user);
        return new ModelAndView("redirect:/dashboard");

    }

    @PostMapping("/profile/delete")
    public ModelAndView delete(@RequestParam("id") int id)
    {
        UserT userById = userDao.getUserById(id);

        userDao.deteleUser(userById);

        return new ModelAndView("redirect:/dashboard");
    }
}
