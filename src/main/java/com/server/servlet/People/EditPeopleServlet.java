package com.server.servlet.People;

import com.server.dao.UserDao;
import com.server.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditPeopleServlet",urlPatterns = "/People/EditPeopleServlet")
public class EditPeopleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_id=new String (request.getParameter("u_id").getBytes("ISO8859-1"), "UTF-8");
        String u_name=new String (request.getParameter("u_name").getBytes("ISO8859-1"), "UTF-8");
        String u_class=new String (request.getParameter("u_class").getBytes("ISO8859-1"), "UTF-8");
        String u_grade=new String (request.getParameter("u_grade").getBytes("ISO8859-1"), "UTF-8");
        String u_account=new String (request.getParameter("u_account").getBytes("ISO8859-1"), "UTF-8");

        User us=new User();
        us.setU_id(Integer.parseInt(u_id));
        us.setU_name(u_name);
        us.setU_class(u_class);
        us.setU_grade(u_grade);
        us.setU_account(u_account);

        if(new UserDao().updateAccount(us))
            request.setAttribute("result","true");
        else
            request.setAttribute("result","false");

        request.getRequestDispatcher("/People/PeopleEdit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
