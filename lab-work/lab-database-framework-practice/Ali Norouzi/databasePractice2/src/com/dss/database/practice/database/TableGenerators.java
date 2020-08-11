package com.dss.database.practice.database;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class TableGenerators {
    private TableGenerator tableGenerator = new TableGenerator();
    public void getEntities(List<String> stack) throws ClassNotFoundException {
                for (int i = 0; i< stack.size(); i++){
                    String className = stack.get(i);
                    System.out.println(className);
                    TableGenerator.tableGenerator(className);
                }
    }
}

