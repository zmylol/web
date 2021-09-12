package com.zmy.Servlet;

import com.zmy.entity.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/getuser")
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //1.接收参数
        String uid = req.getParameter("uid");
        int userid=Integer.parseInt(uid);
        User users=null;
        switch (userid){
            case  1:
                users=new User(1,"张三","abc");
                break;
            case  2:
                users=new User(2,"张三2","abc2");
                break;
            case  3:
                users=new User(3,"张三3","abc3");
                break;
            case  4:
                users=new User(4,"张三4","abc4");
                break;
            default:
                users=new User();
        }

        //java->json
        JSONObject jsonObject = JSONObject.fromObject(users);//json

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(jsonObject);

    }
}
