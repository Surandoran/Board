package com.example.controller.board;

import com.example.controller.SubController;
import com.example.dto.BoardDTO;
import com.example.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardListController implements SubController {

    BoardService service = BoardService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        try {

            int start = 0;
            int end = 0;

            List<BoardDTO> list = service.getBoardList(start, end);

            req.setAttribute("list",list);

            req.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
