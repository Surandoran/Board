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

            //파라미터 확인
            String tmpstart = req.getParameter("start");
            String tmpend = req.getParameter("end");
            String nowPage = req.getParameter("nowPage");

            int start = 0;
            int end = 0;
            if(tmpstart == null || tmpend == null){
                start = 1;
                end = 10;
            }else {
                start = Integer.parseInt(tmpstart);
                end = Integer.parseInt(tmpend);
            }
            //입력값 검증
            // 서비스실행
            List<BoardDTO> list = service.getBoardList(start, end); //DAO 호출
            int tcnt = service.getTotalCnt(); //서비스 사용 해서 tcnt 에 담아줌


            req.setAttribute("list", list); // key 와 value 로 저장
            req.setAttribute("tcnt", tcnt);// 담아서 리퀘스트

            //정리 6일차 (페이징처리) 추가가
            req.setAttribute("nowPage", nowPage);

            req.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(req, resp);
        } catch (Exception e) {


            e.printStackTrace();
        }


    }

}
