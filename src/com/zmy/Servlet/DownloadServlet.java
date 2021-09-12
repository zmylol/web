package com.zmy.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/downimg")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename=req.getParameter("filename");
        String path ="/uploadfiles/"+filename;
        resp.setContentType("application/octet-stream");
        resp.addHeader("Content-Disposition","attachment;filename="+filename);
        req.getRequestDispatcher(path).forward(req,resp);
        resp.flushBuffer();
    }
}
