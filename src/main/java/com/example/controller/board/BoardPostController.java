package com.example.controller.board;

import com.example.controller.SubController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardPostController implements SubController {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/board/post.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
