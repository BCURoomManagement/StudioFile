package com.server.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetProgressServlet",urlPatterns ="/GetProgressServlet" )
public class GetProgressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response .setContentType ( "text/plain;charset=utf-8" );
        PrintWriter out=response.getWriter();

        HttpSession sesson=request.getSession();
        sesson.setAttribute("progressBar","11%");
        String str=sesson.getAttribute("progressBar").toString();

        System.out.println(str);
        out.print(str);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
