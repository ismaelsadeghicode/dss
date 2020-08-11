package com.dss.database.practice.database;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

public class TableGenerators {
    private TableGenerator tableGenerator = new TableGenerator();
    public void getEntities(Stack stack) throws ClassNotFoundException {
                for (int i = 0; i< stack.size(); i++){
                    String className = (String) stack.pop();
                    System.out.println(className);
                    TableGenerator.tableGenerator(className);
                }
    }
}

