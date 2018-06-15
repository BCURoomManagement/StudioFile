package com.server.servlet;

import com.server.dao.UserDao;
import com.server.pojo.User;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_account=new String (request.getParameter("u_account").getBytes("ISO8859-1"), "UTF-8");
        String u_password =new String (request.getParameter("u_password").getBytes("ISO8859-1"), "UTF-8");
        String u_name=new String (request.getParameter("u_name").getBytes("ISO8859-1"), "UTF-8");
        String u_class=new String (request.getParameter("u_class").getBytes("ISO8859-1"), "UTF-8");
        String u_grade=new String (request.getParameter("u_grade").getBytes("ISO8859-1"), "UTF-8");
        String workroom=new String (request.getParameter("workroom").getBytes("ISO8859-1"), "UTF-8");

        User us=new User();
        us.setU_account(u_account);
        us.setU_password(u_password);
        us.setU_name(u_name);
        us.setU_class(u_class);
        us.setU_grade(u_grade);
        us.setW_id(Integer.parseInt(workroom));


        response .setContentType ( "text/html;charset=utf-8" );
        PrintWriter out = response .getWriter () ;

        if(new UserDao().checkUserName(u_account).getU_id()==0){
            if(new UserDao().insertAccount(us))
                request.setAttribute("result","true");
            else
                request.setAttribute("result","false");
        }else{
            request.setAttribute("result","again");
        }

        request.getRequestDispatcher("/register.jsp").include(request, response);

        out .flush () ;
        out .close () ;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
