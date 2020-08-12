package com.mapsa.database;

import com.mapsa.persistance.Column;
import com.mapsa.persistance.Table;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUD {

    Connection connection = null;

    public void save(Object object) throws SQLException, IOException, ClassNotFoundException, IllegalAccessException {

        String query;
        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        query ="INSERT INTO "+table.name()+" (";
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Column column = field.getDeclaredAnnotation(Column.class);
            if(column !=null)
            {
                query += column.name()+",";

            }
        }

        if(query.trim().endsWith(","))
        {
            query = query.substring(0,query.length()-1);
        }
      query += ") VALUES (";


        for (Field field : fields) {
            if(field.getType().getSimpleName().equals("String"))
            {
                query += "'"+field.get(object)+"',";
            }
            if(field.getType().getSimpleName().equals("int"))
            {
                query += field.get(object)+",";
            }
        }

        if(query.trim().endsWith(","))
        {
            query = query.substring(0,query.length()-1);
        }

        query += ")";

        connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        System.out.println("INSERT DONE");


        System.out.println(query);






    }

}
