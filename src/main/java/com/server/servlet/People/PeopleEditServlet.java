package com.server.servlet.People;

import com.server.dao.UserDao;
import com.server.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PeopleEditServlet",urlPatterns = "/People/PeopleEditServlet")
public class PeopleEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_id=new String (request.getParameter("u_id").getBytes("ISO8859-1"), "UTF-8");

        User us=new UserDao().getOneUser(Integer.parseInt(u_id));

        request.setAttribute("us",us);
        request.getRequestDispatcher("../People/PeopleEdit.jsp").forward(request,response);

    }
}
