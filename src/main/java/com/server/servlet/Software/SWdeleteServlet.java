package com.server.servlet.Software;

import com.server.dao.SoftwareDao;
import com.server.dao.UserDao;
import com.server.pojo.Software;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SWdeleteServlet",urlPatterns = "/Software/SWdeleteServlet")
public class SWdeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int w_id=new UserDao().getOneUser(Integer.parseInt(request.getSession().getAttribute("u_id").toString())).getW_id();

        List<Software> swList=new SoftwareDao().getOneSWcp(w_id);

        for (Software sw:swList){
            sw.setS_username(new UserDao().getOneUser(sw.getU_id()).getU_name());
        }
        request.setAttribute("swList",swList);


        String s_id=new String (request.getParameter("s_id").getBytes("ISO8859-1"), "UTF-8");

        boolean result=new SoftwareDao().deleteSoftware(Integer.parseInt(s_id));

        if(result)
            request.setAttribute("result","true");
        else
            request.setAttribute("result","false");

        request.getRequestDispatcher("../Software/SoftwareList.jsp").forward(request,response);
    }
}
