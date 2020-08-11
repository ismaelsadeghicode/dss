package com.dss.database.practice.database;

import com.dss.database.practice.annotations.Column;
import com.dss.database.practice.annotations.Entity;
import com.dss.database.practice.annotations.Id;
import com.dss.database.practice.annotations.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUD implements CRUDDB {
    private DBConnection dbConnection;
    private Connection connection;

    @Override
    public void save(Object object) throws ClassNotFoundException, IllegalAccessException, SQLException {
        Class<?> class1 = object.getClass();
        String query = "INSERT INTO ";
        Entity entity = (Entity) class1.getDeclaredAnnotation(Entity.class);
        Table table = (Table) class1.getDeclaredAnnotation(Table.class);
        query += table.name() +" (";
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Column column = field.getDeclaredAnnotation(Column.class);
            if(column!=null){
                query += column.name()+",";
            }
        }
        if(query.trim().endsWith(",")){
            query = query.substring(0,query.length()-1);
        }
        query += ") VALUES (";
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getType().getSimpleName().endsWith("String")){
                query += "'"+field.get(object)+"',";
            }else {
                query += field.get(object)+",";
            }
        }
        if(query.trim().endsWith(",")){
            query = query.substring(0,query.length()-1);
        }
        query += ")";
        dbConnection = DBConnection.getInstance();
        connection = dbConnection.openConnection();
        PreparedStatement statement =connection.prepareStatement(query);
        statement.execute();
    }

    @Override
    public void update(Object object) throws IllegalAccessException, SQLException {
        Class<?> class1 = object.getClass();
        Table table = (Table) class1.getDeclaredAnnotation(Table.class);
        String query ="UPDATE "+ table.name() + " SET ";
        Field[] fields = class1.getDeclaredFields();
        Object id2 = new Object();
        String idColumn = null;
        for (Field field : fields) {
            field.setAccessible(true);
            Id id = field.getDeclaredAnnotation(Id.class);
            Column column = field.getDeclaredAnnotation(Column.class);
            if(id!=null){
                id2=field.get(object);
                idColumn = field.getName();
            }else if (column!=null){
                if(field.getType().getSimpleName().endsWith("String")){
                    query+= column.name()+"='"+field.get(object)+"',";
                }else {
                    query+= column.name()+"="+field.get(object)+",";
                }
            }
        }
        if(query.trim().endsWith(",")){
            query = query.substring(0,query.length()-1);
        }

        query+=" WHERE "+ idColumn + "=" + id2 ;

        System.out.println(query);

        dbConnection = dbConnection.getInstance();
        PreparedStatement statement = dbConnection.openConnection().prepareStatement(query);
        statement.executeUpdate();
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void findAll(Object object) {

    }

    @Override
    public void findOne(Object object) {

    }
}
