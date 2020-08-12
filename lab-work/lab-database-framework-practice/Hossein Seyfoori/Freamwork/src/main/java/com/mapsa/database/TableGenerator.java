package com.mapsa.database;

import com.mapsa.persistance.Column;
import com.mapsa.persistance.Entity;
import com.mapsa.persistance.Table;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.sql.*;

import static com.mapsa.utils.Utils.getClasses;

public class TableGenerator {
     public void createTable(Object object) throws SQLException {

         Connection connection = null;
         try {
             connection = DBConnection.getInstance().getConnection();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }


         Table table = object.getClass().getAnnotation(Table.class);
         String query;
         if(!table.schema().equals(""))
         {
              query = "CREATE TABLE " + table.schema()+"."+table.name() + "(";
         }
         query = "CREATE TABLE "+table.name() + "(";

         Field[] fields = object.getClass().getDeclaredFields();
         for (Field field : fields) {
             Annotation[] annotations = field.getDeclaredAnnotations();
             for (Annotation annotation : annotations) {
                 if (annotation instanceof Column){
                     Column column = field.getDeclaredAnnotation(Column.class);
                     query += column.name()+" "+column.dataType()+"("+column.length()+"),";
                 }
             }
         }

         if(query.trim().endsWith(","))
             query = query.substring(0,query.length()-1);

         query += ")";

         if (connection == null) throw new AssertionError("Connection Null");

         System.out.println(query);


         Statement statement = connection.createStatement();
         statement.executeUpdate(query);



         System.out.println(object.getClass().getName()+ " CREATED");
         System.out.println("-----------------------------");

     }

     public static void createTables(String packageName)
     {
         Iterable<Class> classes = null;
         try {
             classes = getClasses(packageName);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (URISyntaxException e) {
             e.printStackTrace();
         }
         for (Class aClass : classes) {

             Annotation[] annotations = aClass.getDeclaredAnnotations();

             for (Annotation annotation : annotations) {
                 if(annotation instanceof Entity)
                 {
                     TableGenerator tableGenerator = new TableGenerator();
                     try {
                         tableGenerator.createTable(aClass.newInstance());
                     } catch (SQLException throwables) {
                         throwables.printStackTrace();
                     } catch (InstantiationException e) {
                         e.printStackTrace();
                     } catch (IllegalAccessException e) {
                         e.printStackTrace();
                     }

                 }
             }

         }
     }
}
