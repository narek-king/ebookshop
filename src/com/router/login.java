package com.router;

/**
 * Created by King on 12/2/2015.
 */
import java.io.IOException;
import java.io.PrintWriter;

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
    private final String userID = "serjik";
    private final String password = "heracir";

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
//        String  username = respon
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
//        System.out.println("user: " + user +", Pass: "+ pwd);

        if(userID.equals(user) && password.equals(pwd)){
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

    }

}
