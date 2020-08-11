package com.dss.database.practice.database;

import java.sql.SQLException;

public interface CRUDDB {
    void save (Object object) throws ClassNotFoundException, IllegalAccessException, SQLException;

    void  update(Object object) throws IllegalAccessException, SQLException;

    void delete(Object object);

    void findAll(Object object);

    void findOne(Object object);
}
