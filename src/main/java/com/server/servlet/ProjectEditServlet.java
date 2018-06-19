package com.server.servlet;

import com.server.dao.ProjectFileDao;
import com.server.pojo.ProjectFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProjectEditServlet",urlPatterns ="/ProjectEditServlet")
public class ProjectEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id=new String (request.getParameter("p_id").getBytes("ISO8859-1"), "UTF-8");
        ProjectFile pf=new ProjectFileDao().getOnePF(Integer.parseInt(p_id));

        request.setAttribute("pf",pf);
        request.getRequestDispatcher("/ProjectEdit.jsp").forward(request,response);
    }
}
