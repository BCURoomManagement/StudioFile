package com.server.servlet;

import com.server.dao.ProjectFileDao;
import com.server.dao.UserDao;
import com.server.pojo.ProjectFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProjectListServlet",urlPatterns = "/ProjectListServlet")
public class ProjectListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response .setContentType ( "text/html;charset=utf-8" );
        PrintWriter out = response .getWriter () ;

        int w_id=new UserDao().getOneUser(Integer.parseInt(request.getSession().getAttribute("u_id").toString())).getW_id();
        System.out.println(w_id+"00000000000000000000");
        System.out.println(request.getSession().getAttribute("u_id").toString()+"11111111111111111");
        List<ProjectFile> pfList=new ProjectFileDao().getOneWRpf(w_id);

        request.setAttribute("pfList",pfList);
        System.out.println(pfList.get(0).getP_time());

        request.getRequestDispatcher("/ProjectList.jsp").forward(request,response);

        out .flush () ;
        out .close () ;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
