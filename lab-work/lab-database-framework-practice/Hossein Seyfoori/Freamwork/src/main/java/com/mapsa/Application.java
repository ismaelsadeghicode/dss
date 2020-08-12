package com.mapsa;


import com.mapsa.database.CRUD;
import com.mapsa.database.DBConnection;
import com.mapsa.database.TableGenerator;
import com.mapsa.model.Customer;
import com.mapsa.model.Person;
import com.mapsa.utils.Utils;

import javax.swing.undo.CannotUndoException;
import java.io.IOException;

import java.net.URISyntaxException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Application {
    public static void main(String[] args) throws SQLException, URISyntaxException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {


       TableGenerator.createTables("com.mapsa");


  




    }
}



