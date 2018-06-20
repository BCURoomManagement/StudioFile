package com.server.servlet.Book;

import com.server.dao.BookDao;
import com.server.pojo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookEditServlet",urlPatterns = "/Book/BookEditServlet")
public class BookEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String b_id=new String (request.getParameter("b_id").getBytes("ISO8859-1"), "UTF-8");

        Book bk=new BookDao().getOneBook(Integer.parseInt(b_id));

        request.setAttribute("bk",bk);

        request.getRequestDispatcher("../Book/BookEdit.jsp").forward(request,response);
    }
}
