package com.zmy.Servlet;

import com.zmy.entity.User;
import com.zmy.service.impl.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        PrintWriter out = null;
        ServiceImpl ServiceImpl = new ServiceImpl();
        User user = null;
        HttpSession session=request.getSession();

        userName = request.getParameter("userName");
        password = request.getParameter("password");

        session.setAttribute("userName",userName);

        user = new User(1,userName,password);

        out = response.getWriter();
        if (ServiceImpl.ifExist(user)){
            response.sendRedirect("/index.jsp");
        }else{
            //也会乱码
            response.setContentType("text/html;charset = utf-8");
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }

    }


}
