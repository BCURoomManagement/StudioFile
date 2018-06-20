package com.server.servlet.Software;

import com.server.dao.SoftwareDao;
import com.server.pojo.Software;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SoftwareEditServlet",urlPatterns = "/Software/SoftwareEditServlet")
public class SoftwareEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_id=new String (request.getParameter("s_id").getBytes("ISO8859-1"), "UTF-8");
        Software sw=new SoftwareDao().getOneSW(Integer.parseInt(s_id));

        request.setAttribute("sw",sw);

        request.getRequestDispatcher("../Software/SoftwareEdit.jsp").forward(request,response);
    }
}
