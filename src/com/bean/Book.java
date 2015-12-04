package com.bean;
//import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by King on 11/27/2015.
 */
public class Book {
    private String title;
    private int id;
    private String author;
    private Double price;
    private int qty;
    private String category;
    private String image;
    private ArrayList books= new ArrayList();



    public Book(String title, int id, String author, Double price, int qty, String category, String image) {
        this.title = title;
        this.id = id;
        this.author = author;
        this.price = price;
        this.qty = qty;
        this.category = category;
        this.image = image;

    }

    public Book(){
        setBooks();
    }

    public Book(int id) {
        this.id = id;
        setId();
    }

    public String getTitle(){
        return this.title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public ArrayList getBooks() {
        return books;
    }

    public int getQty() {
        return qty;
    }

    public String getCategory() {
        return category;
    }

    private  void setBooks(){
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
            sql = "select * from books where 1";
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


                books.add(currentBook);



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

        if(this.title == null)
            this.title = "not Set";
    }
    private  void setId(){
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
            sql = "select * from books where id =" + this.id;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                title = rs.getString("title");
                author = rs.getString("author");
                price = rs.getDouble("price");
                qty = rs.getInt("qty");
                category = rs.getString("category");
                image = rs.getString("image");

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

        if(this.title == null)
            this.title = "not Set";
    }
}
