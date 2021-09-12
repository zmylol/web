package com.zmy.Servlet;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
import java.io.IOException;

@WebServlet(urlPatterns = "/uploadtest")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            SmartUpload smartUpload = new SmartUpload();
            PageContext pageContext=JspFactory.getDefaultFactory().getPageContext(this,req,resp,null,false,1024,true);
            smartUpload.initialize(pageContext);
            smartUpload.setCharset("utf-8");
            smartUpload.upload();
            File file=smartUpload.getFiles().getFile(0);
            String fileName =file.getFileName();
            String conntentType = file.getContentType() ;
            String uploadpath="/uploadfiles/"+fileName;
            file.saveAs(uploadpath,File.SAVEAS_VIRTUAL);
            req.setAttribute("filename",fileName);
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
    }
}
