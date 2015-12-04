package com.bean;

import java.sql.*;
import java.util.*;

/**
 * Created by King on 12/4/2015.
 */
public class Cart {
    private User user;
    private ArrayList<item> items = new ArrayList<item>();
    private ArrayList<Book> books = new ArrayList<Book>();
    public Cart(User user) {
        this.user = user;
        getItems();
    }

    public ArrayList<item> getItems(){
        ArrayList currentItems = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "select * from shopping_cart where user_id = \"" + user.getId() + "\"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                int bookID = rs.getInt("book_id");
                int qty = rs.getInt("qty");

               item currentItem = new item(user.getId(),bookID,qty);
                currentItem.setId(id);
                currentItems.add(currentItem);
            }
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
        this.items = currentItems;
        return items;
    }

    public ArrayList<item> addItem(int user_id, int BookID, int qty){

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO shopping_cart (user_id, book_id, qty) VALUES (" + user_id +", "+ BookID +", "+ qty + ")";
            stmt.executeUpdate(sql);
           /* while (rs.next()) {
                int id = rs.getInt("id");
                int bookID = rs.getInt("book_id");
                int qty = rs.getInt("qty");

                Map currentItm = new HashMap();
                currentItm.put("bookid", bookID);
                currentItm.put("qty", qty);
                this.items.add(currentItm);
            }*/

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



        return getItems();
    }

    public void deleteItem(int user_id, int BookID){

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM shopping_cart WHERE user_id = " + user_id + " AND book_id = "+ BookID + " LIMIt 1";
            stmt.executeUpdate(sql);
           /* while (rs.next()) {
                int id = rs.getInt("id");
                int bookID = rs.getInt("book_id");
                int qty = rs.getInt("qty");

                Map currentItm = new HashMap();
                currentItm.put("bookid", bookID);
                currentItm.put("qty", qty);
                this.items.add(currentItm);
            }*/

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

    public void Order (int user_id){

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "DELETE FROM shopping_cart WHERE user_id = " + user_id;
            stmt.executeUpdate(sql);
//            String sqlOrde;
//            sqlOrde = "INSERT INTO orders(user_id, book_id, qty, status) VALUES ([value-1],[value-2],[value-3],[value-4])";
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

    public int getQty () {
        int qty = 0;

        for (int i = 0; i < items.size(); i++)
            qty += items.get(i).getQty();
        return qty;

    }

    public ArrayList getBooks(){
        getItems();
        ArrayList currentBooks = new ArrayList();
        for (int i=0; i < items.size(); i++){
            Book newbook = new Book (items.get(i).getBookID());
            currentBooks.add(newbook);
        }
        this.books = currentBooks;
        return books;
    }

    public double getPrice(){
        getBooks();
        double price = 0;

        for (int i = 0; i < books.size(); i++)
            price += (books.get(i).getPrice()) * items.get(i).getQty();
        return price;
    }

}
