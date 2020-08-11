package com.dss.database.practice.database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Utility {
    private TableGenerators tableGenerators= new TableGenerators();
    public String address;
    public void fileNames(String string) throws ClassNotFoundException {
        this.address=string;
        File file = new File(address);
        File[] listOfFiles = file.listFiles();
        List<String> filenames = new ArrayList<>();
        List<String> classnames = new ArrayList<>();
        for(int i=0; i<listOfFiles.length;i++){
            if (listOfFiles[i].isFile()){
            String a =listOfFiles[i].getName();
            System.out.println(listOfFiles[i].getName());
            filenames.add(a);
            }
        }
        for (int i=0;i<filenames.size();i++){
            String s = filenames.get(i);
            if(s.trim().endsWith(".java")) {
                s=s.substring(0,s.length()-5);
            }
            s = addressRefiner(string) + "."+s;
            System.out.println(s);
           classnames.add(s);
        }
        tableGenerators.getEntities(classnames);
    }
    private static String addressRefiner(String address2){
        String addre1;
        String temp1="";
        String temp;
        String src = "";
        boolean ssA = false;
        boolean ssB = false;
        int rightWhile = 0;

        for (int j = 0; j < address2.length()-4; j++) {
            if(j<address2.length()-1){ssB=false;}
            src = String.valueOf(address2.charAt(j));
            String src2 = String.valueOf(address2.charAt(j + 1));
            String src3 = String.valueOf(address2.charAt(j + 2));
            if (src.equals("s") && src2.equals("r") && src3.equals("c")) {
                rightWhile = j + 3;
                ssB = false;
            }
        }
        for (int j = 0; j < address2.length()-3; j++) {
            temp = String.valueOf(address2.charAt(j));
            if(j<address2.length()-1){ssA=false;}
            if (temp.equals("/") || temp.equals(".") && j < address2.length() - 3) {
                src = String.valueOf(address2.charAt(j + 1));
                String src2 = String.valueOf(address2.charAt(j + 2));
                String src3 = String.valueOf(address2.charAt(j + 3));
                if (src.equals("s") && src2.equals("r") && src3.equals("c")) {
                    rightWhile = j + 3;
                    ssA = false;
                }
            }
        }
        for (int right=rightWhile; right<address2.length();right++){
            temp = String.valueOf(address2.charAt(right));
            if(temp.equals("/")||temp.equals(".")){
                temp1+=".";
            }else{
                temp1+=address2.charAt(right);
            }
        }
        if(temp1.trim().charAt(0)=='.'){
            temp1 = temp1.substring(1,temp1.length());
        }
        System.out.println(temp1);
        return temp1;
    }
}
