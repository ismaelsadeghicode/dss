package com.mapsa.dss.sales.database;

import com.mapsa.dss.sales.model.Person;
import com.mapsa.dss.sales.persistence.Column;
import com.mapsa.dss.sales.persistence.Id;
import com.mapsa.dss.sales.persistence.Table;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CRUD implements CRUDInterface {
    private static DBConnection dbConnection = DBConnection.getInstance();
    private Connection connection = null;

    //    private Object object;
    @Override
    public void read(Object object) throws IOException, SQLException {

        List<Person> people = new ArrayList<>();

        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder readQuery = new StringBuilder("Select * from " + table.name());

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(readQuery.toString());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Person person = new Person();
            person.setPerson_id(resultSet.getInt("person_id"));
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setPassword(resultSet.getString("password"));
            people.add(person);
        }
        for (Person person1 : people) {
            System.out.println(person1);
        }

    }

    @Override
    public void insert(Object object) throws IllegalAccessException {
        // INSERT INTO persons (person_id,first_name,last_name,password) VALUES (1,ali,alavi,123456)

        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder insertQuery = new StringBuilder("INSERT INTO " + table.name() + " (");
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                insertQuery.append(column.name()).append(",");
            }
        }
        new TrimEnd(insertQuery);
        insertQuery.append(") VALUES (");

        for (Field field : fields) {
            if (field.getType().getSimpleName().endsWith("String")) {
                insertQuery.append("'").append(field.get(object)).append("',");
            } else {
                insertQuery.append(field.get(object)).append(",");
            }
        }
        new TrimEnd(insertQuery);
        insertQuery.append(")");

        //connect to db
        try {
            connection = dbConnection.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement statement = null;
            statement = connection.prepareStatement(insertQuery.toString());
            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void update(Object object) throws IllegalAccessException {
        //UPDATE table_name SET column1 = 'value1', column2 = 'value2', ... WHERE id = value;
        Table table = object.getClass().getDeclaredAnnotation(Table.class);
        StringBuilder updateQuery = new StringBuilder("Update " + table.name() + " SET ");
        Field[] fields = object.getClass().getDeclaredFields();
        Object column_id_value = null;
        String column_id_name = null;
        for (Field field : fields) {
            field.setAccessible(true);
            Id id = field.getAnnotation(Id.class);
            Column column = field.getAnnotation(Column.class);
            if (id != null) {
                column_id_value = field.get(object);
                column_id_name = field.getName();
                System.out.println("id v:" + column_id_value + "\t id name=> " + column_id_name);
            }
            if (column != null && id == null) {
                if(field.getType().getSimpleName().endsWith("String")) {
                    updateQuery.append(column.name()).append(" = '").append(field.get(object)).append("', ");
                }else {
                    updateQuery.append(column.name()).append("=").append(field.get(object)).append(", ");
                }
            }
        }
        new TrimEnd(updateQuery);
        updateQuery.append(" WHERE ").append(column_id_name).append(" = ").append(column_id_value);
        System.out.println(updateQuery);

        assert connection != null;
        dbConnection = DBConnection.getInstance();
        PreparedStatement statement = null;
        try {
            statement = dbConnection.getConnection().prepareStatement(updateQuery.toString());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void search(Object object) {
        
    }
}
