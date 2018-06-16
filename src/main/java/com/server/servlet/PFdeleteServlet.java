package com.server.servlet;

import com.server.dao.ProjectFileDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PFdeleteServlet",urlPatterns = "/PFdeleteServlet")
public class PFdeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id=new String (request.getParameter("p_id").getBytes("ISO8859-1"), "UTF-8");

        boolean result=new ProjectFileDao().deleteProjectFile(Integer.parseInt(p_id));

        if(result)
            request.setAttribute("result","删除成功!");
        else
            request.setAttribute("result","删除失败！");

        request.getRequestDispatcher("/ProjectList.jsp").forward(request,response);

    }
}
