package com.dss.sales.services;
/*

import com.dss.sales.annotations.Column;
import com.dss.sales.annotations.Entity;
import com.dss.sales.annotations.Id;
import com.dss.sales.annotations.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Deprecated
public class CRUD implements CRUDDB {
    private Database database;
    private Connection connection;

    @Override
    public void save(Object object) throws IllegalAccessException, SQLException {
        Class<?> class1 = object.getClass();
        Entity entity = (Entity) class1.getDeclaredAnnotation(Entity.class);
        assert entity !=null;
        Table table = (Table) class1.getDeclaredAnnotation(Table.class);
        String query = "INSERT INTO " + table.name() + "(";
        Field[] fields = class1.getDeclaredFields();
        Object id2 = new Object();
        for (Field field : fields) {
            field.setAccessible(true);
            Id id = field.getDeclaredAnnotation(Id.class);
            Column column = field.getDeclaredAnnotation(Column.class);
            if (id != null) {
                id2 = field.get(object);
            }if(column!=null){
                query += " "+ column.name()+",";
            }
        }
        if (query.trim().endsWith(",")){
            query = query.substring(0,query.length()-1);
        }
        query += ") VALUES (";
        for (Field field : fields) {
            if (field.getType().getSimpleName().endsWith("String")) {
                query += "'" + field.get(object) + "',";
            } else {
                query += field.get(object) + ",";
            }
        }
        if (query.trim().endsWith(",")){
            query = query.substring(0,query.length()-1);
        }
        query += ")";
        System.out.println(query);
        PreparedStatement statement = Database.getInstance().openConnection().prepareStatement(query);
        statement.execute();
    }

    @Override
    public void update(Object object) throws IllegalAccessException, SQLException {
        Class<?> class1 = object.getClass();
        Entity entity = (Entity) class1.getDeclaredAnnotation(Entity.class);
        assert entity !=null;
        Table table = (Table) class1.getDeclaredAnnotation(Table.class);
        String query="UPDATE "+ table.name() + "SET ";
        Field[] fields = class1.getDeclaredFields();
        Object id2 = new Object();
        String idname = null;
        for (Field field : fields) {
            field.setAccessible(true);
            Id id = field.getDeclaredAnnotation(Id.class);
            Column column = field.getDeclaredAnnotation(Column.class);
            if(id!=null){
                id2 = field.get(object);
                idname = field.getName();
            }
            if(column!=null){
                query+= " "+ column.name() + "=";
                if(field.getType().getSimpleName().endsWith("String")){
                    query += "'"+field.get(object) + "',";
                    }else {
                        query += field.get(object) + ",";
                    }
            }
        }
        if (query.trim().endsWith(",")){
            query = query.substring(0,query.length()-1);
        }
        query += " WHERE " + idname+"="+id2;
        System.out.println(query);
        PreparedStatement statement = Database.getInstance().openConnection().prepareStatement(query);
        statement.executeUpdate();
    }
}
*/