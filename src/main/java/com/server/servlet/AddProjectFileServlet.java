package com.server.servlet;

import com.server.dao.ProjectFileDao;
import com.server.pojo.ProjectFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddProjectFileServlet",urlPatterns = "/AddProjectFileServlet")
public class AddProjectFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_id=new String (request.getParameter("u_id").getBytes("ISO8859-1"), "UTF-8");
        String p_name=new String (request.getParameter("p_name").getBytes("ISO8859-1"), "UTF-8");
        String p_time=new String (request.getParameter("p_time").getBytes("ISO8859-1"), "UTF-8");

        ProjectFile pf=new ProjectFile();
        pf.setU_id(Integer.parseInt(u_id));
        pf.setP_name(p_name);
        pf.setP_time(p_time);
        request.setAttribute("result",new ProjectFileDao().insertProjectFile(pf));

        request.getRequestDispatcher("/ProjectAdd.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
