package com.bean;

import java.sql.*;


/**
 * Created by King on 12/2/2015.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private Double balance;

    public User(int id) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "select * from user where id = \"" + id + "\"";
            ResultSet rs = stmt.executeQuery(sql);
                 rs.moveToCurrentRow();
               this.id = rs.getInt("id");
               this.username = rs.getString("username");
               this.password = rs.getString("password");
                this.balance = rs.getDouble("balance");

            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
//        System.out.println("id is " + id);

    }

    public User(String username) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "select * from user where username = \"" + username + "\"";

            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            this.id = rs.getInt("id");
            this.username = rs.getString("username");
            this.password = rs.getString("password");
            this.balance = rs.getDouble("balance");
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Double getBalance() {
        return balance;
    }
}
