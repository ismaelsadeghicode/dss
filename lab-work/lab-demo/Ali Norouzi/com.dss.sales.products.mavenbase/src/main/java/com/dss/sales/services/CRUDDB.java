package com.dss.sales.services;

import java.sql.SQLException;

@Deprecated
public interface CRUDDB {
    void save(Object object) throws IllegalAccessException, SQLException;

    void update(Object object) throws IllegalAccessException, SQLException;
}
