package com.example.controller.member;

import com.example.controller.SubController;
import com.example.dto.MemberDTO;
import com.example.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberInfoController implements SubController {

    MemberService service = MemberService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("경덕이형 컨트롤로 진입!@!!");
        //파라미터 받기

        try {

            //서비스 실행
                HttpSession session = req.getSession();
                String email = (String) session.getAttribute("email");
                MemberDTO dto = service.MemberSearch(email);
                req.setAttribute("dto", dto);
//                req.setAttribute("email", dto.getEmail());
//                req.setAttribute("addr1", dto.getAddr1());
//                req.setAttribute("addr2", dto.getAddr2());
                //아이디 조회 실패.. 해당 아이디가 없습니다.
                req.getRequestDispatcher("/WEB-INF/member/MyInfo.jsp").forward(req, resp);
            }catch (Exception e){
            e.printStackTrace();
        }
    }

}
