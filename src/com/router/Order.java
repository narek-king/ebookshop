package com.router;

import com.bean.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/order")
public class Order extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) userName = cookie.getValue();
            }
            User user = new User(userName);
            Cart cart = new Cart(user);
            cart.Order(user.getId());
            PrintWriter out= response.getWriter();
            out.println("<p><font color=red>Your Order is accepted.</p> <p> Thank you for choosing our website.</font></p>" +
                    "  <p><a href = \"welcome?page=main\">You can go back to main page</a> </p>");

        }

    }
}
