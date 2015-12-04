package com.router;

import com.bean.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/delete")
public class Delete extends HttpServlet {
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
            int id = Integer.parseInt(request.getParameter("book_id"));
            cart.deleteItem(user.getId(), id);
            response.sendRedirect(response.encodeRedirectURL("/welcome?page=cart"));
        }

    }
}
