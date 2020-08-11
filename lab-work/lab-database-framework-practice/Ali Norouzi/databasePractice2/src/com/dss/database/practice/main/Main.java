package com.dss.database.practice.main;

import com.dss.database.practice.database.CRUD;
import com.dss.database.practice.database.Utility;
import com.dss.database.practice.model.Users;

import java.sql.SQLException;

public class Main {
    private static Users users = new Users();

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException {
       /* Utility utility = new Utility();
        utility.fileNames("src/com/dss/database/practice/model");*/
        CRUD crud= new CRUD();
        users.setUsername("ALInorouzi");
        users.setPassword("Norouzi79");
        users.setPhoneNumber(910921579);
        users.setId(0);
        crud.update(users);
    }
}
