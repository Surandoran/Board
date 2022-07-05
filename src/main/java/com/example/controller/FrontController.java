package com.example.controller;

import com.example.controller.member.MemberJoinController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class FrontController extends HttpServlet {

    //URL: SubController객체
    HashMap <String,SubController> list = null;

    @Override
    public void init() throws ServletException {
        list = new HashMap<>();

        list.put("/MemberJoin.do", new MemberJoinController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String url = req.getRequestURI();
//        System.out.println("URL: " + url);
        SubController sub = list.get(url);
        if(sub != null) {
            sub.execute(req, resp);
        }
    }

}
