package com.zhuoyue.action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;


//注解
//标注和解释
@WebServlet(urlPatterns = {"/show","/a"})
public class ShowAction extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws  ServletException,IOException{

        PrintWriter out = response.getWriter();
        out.println("hello world");//客户端
        System.out.println();//控制台

    }

}
