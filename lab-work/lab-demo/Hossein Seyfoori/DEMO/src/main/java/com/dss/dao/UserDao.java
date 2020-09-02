package com.dss.dao;

import com.dss.model.UserT;

import java.util.List;

public interface UserDao {
    List<UserT> findAllUsers();
    UserT getUserById(int id);
    UserT getUserByEmail(String email);
    UserT getUserByUsername(String username);
    void insertUser(UserT tbluser);
    void updateUser(UserT tbluser);
    void deteleUser(UserT tbluser);




}
