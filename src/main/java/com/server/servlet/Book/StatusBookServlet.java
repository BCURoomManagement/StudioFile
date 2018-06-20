package com.server.servlet.Book;

import com.server.dao.BookDao;
import com.server.dao.UserDao;
import com.server.pojo.Book;
import sun.awt.image.IntegerInterleavedRaster;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StatusBookServlet",urlPatterns = "/Book/StatusBookServlet")
public class StatusBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String b_id=new String (request.getParameter("b_id").getBytes("ISO8859-1"), "UTF-8");
        String b_status=new String (request.getParameter("b_status").getBytes("ISO8859-1"), "UTF-8");
        int u_id=Integer.parseInt(request.getSession().getAttribute("u_id").toString());

        if(b_status.equals("0"))
            u_id=0;

        if(new BookDao().changeStatus(Integer.parseInt(b_id),Integer.parseInt(b_status),u_id))
            request.setAttribute("result","true");
        else
            request.setAttribute("result","false");


        int w_id=new UserDao().getOneUser(Integer.parseInt(request.getSession().getAttribute("u_id").toString())).getW_id();
        List<Book> bkList=new BookDao().getOneWRBook(w_id);

        for (Book bk:bkList){
            if(bk.getU_id()==0)
                bk.setUsername("无");
            else
                bk.setUsername(new UserDao().getOneUser(Integer.parseInt(request.getSession().getAttribute("u_id").toString())).getU_name());
        }
        request.setAttribute("bkList",bkList);

        request.getRequestDispatcher("../Book/BookList.jsp").forward(request,response);
    }
}
