package com.router;

/**
 * Created by King on 12/2/2015.
 */
import com.bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
//        String  username = respon
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if(findUser(user)){
            User newUser = new User(user);
            if (newUser.getPassword().equals(pwd)){
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                //setting session to expiry in 30 mins
                session.setMaxInactiveInterval(30*60);
                Cookie userName = new Cookie("user", user);
                userName.setMaxAge(30*60);
                response.addCookie(userName);
                response.sendRedirect("/welcome?page=main");
            } else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome?page=login&result=fail");
                PrintWriter out= response.getWriter();
                out.println("<font color=red>Either user name or password is wrong.</font>  <p><a href = \"welcome?page=register\">Register </a> or <a href=\"welcome?page=login\" id=\"login\">Try Again</a></p>");
                rd.include(request, response);
                 }
            }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome?page=login&result=fail");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>  <p><a href = \"welcome?page=register\">Register </a> or <a href=\"welcome?page=login\" id=\"login\">Try Again</a></p>");
            rd.include(request, response);
                  }
        }

    private boolean findUser(String usern){
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
            sql = "SELECT COUNT(*) AS rowcount FROM user WHERE username = \"" + usern + "\" GROUP BY username";
            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
            rs.next();
                count = rs.getInt("rowcount");
//                System.out.println(count);
                if (count>0)
                    val = true;
//            }


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
//        System.out.println(val);
        return val;
    }

}
