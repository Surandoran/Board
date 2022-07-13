package com.example.controller.board;

import com.example.controller.SubController;
import com.example.dto.BoardDTO;
import com.example.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class BoardPostController implements SubController {

    BoardService service = BoardService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        String flag = req.getParameter("flag");
        try {

            if (flag == null) //list.jsp에서 글쓰기 버튼을 누른 경우
            {
                req.getRequestDispatcher("/WEB-INF/board/post.jsp").forward(req, resp);
            } else //post.jsp 에서 등록할 내용을 기입하고 글쓰기 버튼을 누른 경우
            {
                // 1 파라미터
                //title, content, pwd, writer , ip (filename, filesize)...
                String title = req.getParameter("title");
                String content = req.getParameter("content");
                String pwd = req.getParameter("pwd");
                String ip = req.getRemoteAddr();
                HttpSession session = req.getSession();
                String writer = (String) session.getAttribute("email");

                // 2 입력값
                if (title == null || content == null || pwd == null || ip == null) {
                    req.getRequestDispatcher("/WEB-INF/board/post.jsp").forward(req, resp);
                    return;
                }


                // 3 서비스실행
                BoardDTO dto = new BoardDTO();
                dto.setTitle(title);
                dto.setContent(content);
                dto.setPwd(pwd);
                dto.setIp(ip);
                dto.setWriter(writer);

                boolean result = service.PostBoard(dto);
                // 4 View
                if (result) {
                    int tcnt = service.getTotalCnt();
                    req.setAttribute("tcnt", tcnt);
                    ArrayList<BoardDTO> list = (ArrayList<BoardDTO>) service.getBoardList(1, 10);
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/WEB-INF/board/list.jsp?nowpage=1").forward(req, resp);

//                    resp.sendRedirect("/Board/post.do");

                    return;
                } else {
                    req.getRequestDispatcher("/WEB-INF/board/post.jsp").forward(req, resp);
                    return;
                }

            }

        } catch (Exception e) {


            e.printStackTrace();
        }
    }

}
