package com.server.servlet.Competition;

import com.server.dao.CompetitionDao;
import com.server.pojo.Competition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CompetitionEditServlet",urlPatterns = "/Competition/CompetitionEditServlet")
public class CompetitionEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_id=new String (request.getParameter("c_id").getBytes("ISO8859-1"), "UTF-8");
        Competition cp=new CompetitionDao().getOneCp(Integer.parseInt(c_id));

        request.setAttribute("cp",cp);

        request.getRequestDispatcher("../Competition/CompetitionEdit.jsp").forward(request,response);
    }
}
