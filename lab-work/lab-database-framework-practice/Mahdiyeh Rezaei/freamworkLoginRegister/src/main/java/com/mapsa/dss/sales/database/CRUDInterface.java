package com.mapsa.dss.sales.database;

import java.io.IOException;
import java.sql.SQLException;

public interface CRUDInterface {
    public void insert(Object object) throws IllegalAccessException;
    public void update(Object object) throws IllegalAccessException;
    public void read(Object object) throws IOException, SQLException;
    public void delete(Object object);
    public void search(Object object); //find by id
}
