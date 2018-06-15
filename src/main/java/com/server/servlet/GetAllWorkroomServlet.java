package com.server.servlet;

import com.server.dao.WorkroomDao;
import com.server.pojo.Workroom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllWorkroomServlet",urlPatterns = "/GetAllWorkroomServlet")
public class GetAllWorkroomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Workroom> wrList=new WorkroomDao().getAllWrokroom();
        request.setAttribute("workroom",wrList);

        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
