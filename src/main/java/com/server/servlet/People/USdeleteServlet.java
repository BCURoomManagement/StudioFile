package com.server.servlet.People;

import com.server.dao.UserDao;
import com.server.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "USdeleteServlet",urlPatterns = "/People/USdeleteServlet")
public class USdeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int w_id=new UserDao().getOneUser(Integer.parseInt(request.getSession().getAttribute("u_id").toString())).getW_id();

        List<User> usList=new UserDao().getOneWRUser(w_id);

        request.setAttribute("usList",usList);

        String u_id=new String (request.getParameter("u_id").getBytes("ISO8859-1"), "UTF-8");

        boolean result=new UserDao().deleteUser(Integer.parseInt(u_id));

        if(result)
            request.setAttribute("result","true");
        else
            request.setAttribute("result","false");


        request.getRequestDispatcher("../People/PeopleList.jsp").forward(request,response);
    }
}
