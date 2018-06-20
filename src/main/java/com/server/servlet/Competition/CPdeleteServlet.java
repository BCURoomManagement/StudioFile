package com.server.servlet.Competition;

import com.server.dao.CompetitionDao;
import com.server.dao.UserDao;
import com.server.pojo.Competition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CPdeleteServlet",urlPatterns = "/Competition/CPdeleteServlet")
public class CPdeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c_id=new String (request.getParameter("c_id").getBytes("ISO8859-1"), "UTF-8");

        boolean result=new CompetitionDao().deleteCompetiton(Integer.parseInt(c_id));

        if(result)
            request.setAttribute("result","true");
        else
            request.setAttribute("result","false");

        int w_id=new UserDao().getOneUser(Integer.parseInt(request.getSession().getAttribute("u_id").toString())).getW_id();

        List<Competition> cpList=new CompetitionDao().getOneWRcp(w_id);

        for (Competition cp:cpList){
            cp.setC_username(new UserDao().getOneUser(cp.getU_id()).getU_name());
        }

        request.setAttribute("cpList",cpList);

        request.getRequestDispatcher("../Competition/CompetitionList.jsp").include(request,response);
    }
}
