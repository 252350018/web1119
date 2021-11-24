package com.zhuoyue.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterAction  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GB2312");
        response.setCharacterEncoding("GB2312");
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        //String loves = request.getParameter("loves"); //只能获取一个值
        String[] loves = request.getParameterValues("loves");
        String lovesvalue="";
        for(int i=0;i<loves.length;i++){
            lovesvalue+=loves[i]+",";
        }
        //String
        lovesvalue=lovesvalue.substring(0,lovesvalue.length()-1);
        PrintWriter out = response.getWriter();
        out.print(username+" "+userpass+" "+lovesvalue);

    }
}
