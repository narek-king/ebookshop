package com.router;

import com.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by King on 12/2/2015.
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/register")
public class register extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out= response.getWriter();


        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if (findUser(user)){
//            PrintWriter out= response.getWriter();
            out.println("<font color=red>The User name exists</font>  <p><a href = \"welcome?page=register\">Try Agein </a> or <a href=\"welcome?page=login\" id=\"login\">Log In</a></p>");
        } else {
              register(user, pwd);

                out.println("<font color=red>Registration was successful</font>  <a href=\"welcome?page=login\" id=\"login\">now please Log In with your new account</a></p>");

        }


   }


    private boolean findUser(String username){
        boolean val = false;
        int count;
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT COUNT(*) AS rowcount FROM user WHERE username = \"" + username + "\" GROUP BY username";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            count = rs.getInt("rowcount");
            if (count>0)
                val = true;
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
        System.out.println(val);
        return val;
    }

    private void register (String username, String password){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO user (username, password, balance) VALUES (\" " + username +"\", \""+ password +"\", "+ 1000 + ")";
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

}
