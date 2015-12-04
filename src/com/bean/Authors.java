package com.bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by King on 12/1/2015.
 */
public class Authors  {

    private String author;
    private ArrayList authorList = new ArrayList();
    private ArrayList authorbooks = new ArrayList();

    public Authors (){
        setAuthorList();
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private void setAuthorList() {

        Connection conn = null;
        Statement stmt = null;
        ArrayList newList = new ArrayList();
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");

            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "select id, author from books where 1 GROUP BY author";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int idi = rs.getInt("id");
                String authori = rs.getString("author");


                Map currentBook = new HashMap();
                currentBook.put("id", idi);
                currentBook.put("author", authori);

                newList.add(currentBook);
//                System.out.println(authori);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
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
//        System.out.println("Goodbye!");
        this.authorList = newList;

    }

    // returns list of authors
    public ArrayList getAuthorList() {
        return authorList;
    }

    // returns all books of the $author
    public ArrayList getAuthorbooks() {
        return authorbooks;
    }

    public void setAuthorbooks(String author) {
        ArrayList newbooks = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");

            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "select * from books where author = \"" + author +"\"";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int idi = rs.getInt("id");
                String titlei = rs.getString("title");
                String authori = rs.getString("author");
                Double pricei = rs.getDouble("price");
                int qtyi = rs.getInt("qty");
                String categoryi = rs.getString("category");
                String imagei = rs.getString("image");

                Map currentBook = new HashMap();
                currentBook.put("id", idi);
                currentBook.put("title", titlei);
                currentBook.put("author", authori);
                currentBook.put("price", pricei);
                currentBook.put("qty", qtyi);
                currentBook.put("category", categoryi);
                currentBook.put("image", imagei);


                newbooks.add(currentBook);



                //Display values

//            System.out.println("Last: " + title);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
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
//        System.out.println("Goodbye!");


        this.authorbooks = newbooks;
    }
}
