package com.dss.service;

import com.dss.dao.UserDao;
import com.dss.model.UserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public UserT getUserById(int id, String phone_number, String email, String first_name, String last_name){
        UserT userById = userDao.getUserById(id);
        userById.setFirst_name(first_name);
        userById.setLast_name(last_name);
        userById.setEmail(email);
        userById.setPhone_number(phone_number);
        return userById;
    }

    @Bean
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
