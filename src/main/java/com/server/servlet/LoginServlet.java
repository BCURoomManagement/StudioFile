package com.server.servlet;

import com.server.dao.UserDao;
import com.server.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_account=new String (request.getParameter("u_account").getBytes("ISO8859-1"), "UTF-8");
        String u_password=new String(request.getParameter("u_password").getBytes("ISO8859-1"),"UTF-8");

        User us=new UserDao().checkUser(u_account,u_password);

        if(us.getU_id()==0){
            request.setAttribute("massage","登录名或密码错误!");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
