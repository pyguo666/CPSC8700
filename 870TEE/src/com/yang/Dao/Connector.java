package com.yang.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Connector {
    // JDBC driver name and database URL
    private  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private  String DB_URL = "jdbc:mysql://47.89.176.197/8700";
    //  Database credentials
    private  String USER = "root";
    private  String PASS = "Pf123456";
    private String sql = "SELECT name, password FROM administrator";
    private ResultSet rs =null;
    private Connection conn = null;
    private Statement stmt = null;

    public List<Map<String,Object>>connect(String sql) {
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData(); //get meta data
            int columnCount = md.getColumnCount();   //get col number
            while (rs.next()) {
                Map<String,Object> rowData = new HashMap<String,Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
//            //STEP 5: Extract data from result set
//            while(rs.next()){
//                //Retrieve by column name
//                String name  = rs.getString("name");
//                String password = rs.getString("password");
//
//                //Display values
//                System.out.print("name: " + name);
//                System.out.print(", password: " + password);
//            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
            return list;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return null;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return null;
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main

    public int update(String sql) {
        int r=0;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            r = stmt.executeUpdate(sql);

            rs.close();
            stmt.close();
            conn.close();
            return r;
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            return r;
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
            return r;
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }//end main
}
