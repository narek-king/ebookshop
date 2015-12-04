package com.router;

import com.bean.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;


public class welcome extends HttpServlet{
    private static User currentUser;
    private static Cart userCart;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{

        String page = request.getParameter("page");
        String category = request.getParameter("category");
        String gotAuthor = request.getParameter("author");

        Book newBook = new Book();
        ArrayList booksList = newBook.getBooks();
        Authors authors = new Authors();
        ArrayList allAuthors = authors.getAuthorList();
        Category categories = new Category();
        ArrayList allCategories = categories.getCategoryList();
//        System.out.println(allAuthors.get(0));
        request.setAttribute("book", booksList);
        request.setAttribute("authors", allAuthors);
        request.setAttribute("categories", allCategories);
        if(page == null || page.isEmpty()){
             page = "main";

        }
       else if (page.equals("category")) {
            categories.setCategoryBooks(category);
            ArrayList categoryBooks = categories.getCategoryBooks();
            request.setAttribute("categorybooks", categoryBooks);
        } else if (page.equals("author")){

        authors.setAuthorbooks(gotAuthor);
        ArrayList authorBooks = authors.getAuthorbooks();
        request.setAttribute("authorbooks", authorBooks);
//            page = "category";
//            request.setAttribute("category", category);
        }
        String user = chackUser(request,response);
        if (user != null) {
            currentUser = new User(user);
            userCart = new Cart(currentUser);
            int qty = userCart.getQty();
            double price = userCart.getPrice();


            request.setAttribute("user", user);
            request.setAttribute("price", price);
            request.setAttribute("qty", qty);
            if (page.equals("cart")){
                ArrayList books = userCart.getBooks();
                request.setAttribute("cart", books);
            }
        }

        request.setAttribute("category", category);
        request.setAttribute("page", page);
        request.setAttribute("author", gotAuthor);
        RequestDispatcher view=request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException{
        if (userCart != null){
             int id = Integer.parseInt(request.getParameter("book_id"));
            userCart.addItem(currentUser.getId(), id, 1);
            response.sendRedirect(response.encodeRedirectURL("/welcome?page=cart"));

        }

    }

    public String chackUser (HttpServletRequest request, HttpServletResponse response){
        String userName = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) userName = cookie.getValue();
            }
        }
//
        return userName;
    }
}

