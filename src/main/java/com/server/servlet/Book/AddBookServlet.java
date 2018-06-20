package com.server.servlet.Book;

import com.server.dao.BookDao;
import com.server.dao.UserDao;
import com.server.pojo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBookServlet",urlPatterns = "/Book/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String b_name=new String (request.getParameter("b_name").getBytes("ISO8859-1"), "UTF-8");
        String b_provide=new String (request.getParameter("b_provide").getBytes("ISO8859-1"), "UTF-8");

        Book bk=new Book();
        bk.setW_id(new UserDao().getOneUser(Integer.parseInt(request.getSession().getAttribute("u_id").toString())).getW_id());
        bk.setB_name(b_name);
        bk.setB_provide(b_provide);

        if(new BookDao().insertBook(bk))
            request.setAttribute("result","true");
        else
            request.setAttribute("result","false");

        request.getRequestDispatcher("/Book/BookAdd.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
