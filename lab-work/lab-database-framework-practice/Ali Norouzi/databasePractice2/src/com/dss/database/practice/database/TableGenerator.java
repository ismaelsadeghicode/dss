package com.dss.database.practice.database;

import com.dss.database.practice.annotations.Column;
import com.dss.database.practice.annotations.Entity;
import com.dss.database.practice.annotations.Table;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;

public class TableGenerator {
    public static void tableGenerator(String string) throws ClassNotFoundException {
        Class<?> class1 = Class.forName(string);
        Entity entity = (Entity) class1.getAnnotation(Entity.class);
        //This will search if the class has entity annotation or not
        assert entity != null;
        Table table = (Table) class1.getAnnotation(Table.class);
        String query = "create table " + table.name()+"(";
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            Column column = (Column) field.getDeclaredAnnotation(Column.class);
            query += column.name() + " "+column.dataType()+"("+column.length()+")";
            if (column.primaryKey()){
                query += " primary key";
            }if(column.unique()){
                query += " unique";
            }if (column.nullable()){
                query += " null,";
            }else {
                query += " not null,";
            }
        }
        if (query.trim().endsWith(",")){
            query = query.substring(0,query.length()-1);
        }
        query += " )";
        System.out.println(query);
        Statement statement = null;
        try {
            statement = DBConnection.getInstance().openConnection().prepareStatement(query);
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
