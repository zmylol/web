package com.zmy.Servlet;

import com.zmy.dao.UserDao;
import com.zmy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/testuname")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("username");
        System.out.println("TestServlet--username----:"+userName);
        String userName1 =  new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
        System.out.println("TestServlet--username----:"+userName1);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if ("ddd".equals(userName)){
            writer.println("用户已被注册");
        }else{
            writer.println("用户可用");
        }
    }
}
