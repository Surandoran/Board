package com.example.controller.auth;

import com.example.controller.SubController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements SubController {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
        session.invalidate();

        try {
            req.setAttribute("MSG", "로그아웃 완료");
            req.getRequestDispatcher("/").forward(req,resp);
//            resp.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
