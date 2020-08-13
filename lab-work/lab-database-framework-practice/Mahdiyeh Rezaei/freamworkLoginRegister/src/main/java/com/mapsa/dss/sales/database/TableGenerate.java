package com.mapsa.dss.sales.database;

import com.mapsa.dss.sales.persistence.Column;
import com.mapsa.dss.sales.persistence.Table;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Component
public class TableGenerate {
    public void createTable(Object object){
        DBConnection dbConnection = DBConnection.getInstance();
        Connection connection = null;
        try {
            connection = dbConnection.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE " + table.name() + " (");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Column) {
                    Column column = field.getAnnotation(Column.class);
                    stringBuilder.append(column.name()).append(" ").append(column.dataType())
                            .append("(").append(column.length()).append("),");
                }
            }
        }
        new TrimEnd(stringBuilder);
        stringBuilder.append(")");
        System.out.println(stringBuilder);

        assert connection != null;
        try {
            PreparedStatement statement = connection.prepareStatement(stringBuilder.toString());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
