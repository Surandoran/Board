package com.example.controller.member;

import com.example.controller.SubController;
import com.example.dto.MemberDTO;
import com.example.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MemberUpdateController implements SubController {

    MemberService memberService = MemberService.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        String flag = req.getParameter("flag");

        try {
            if (flag == null) { // myinfo,jsp 에서 요청받음
                req.getRequestDispatcher("/WEB-INF/member/password.jsp").forward(req, resp);
            } else { //password.jsp 에서 요청받음
                //패스워드 검증 일치한다면 정보수정처리
                String pwd = req.getParameter("pwd");

                HttpSession session = req.getSession();
                String email = (String)session.getAttribute("email");
                MemberDTO dto = memberService.MemberSearch(email);

                if(memberService.passwordEncoder.checkpw(pwd, dto.getPwd())) {
                    //패스워드가 일치할 경우-> 수정된 값 파라미터 받기
                    String addr1 = req.getParameter("addr1");
                    String addr2 = req.getParameter("addr2");
                    String newpwd = req.getParameter("newpwd");


                    dto.setAddr1(addr1);
                    dto.setAddr2(addr2);

                    newpwd = memberService.passwordEncoder.hashpw(newpwd,
                            memberService.passwordEncoder.gensalt());

                    System.out.println(newpwd);
                    dto.setPwd(newpwd);

                    // dto단위로 담아서 service 함수로 전달
                    memberService.MemberUpdate(dto);

                    //View 이동
                    req.setAttribute("dto", dto);
                    req.getRequestDispatcher("/WEB-INF/member/MyInfo.jsp").forward(req, resp);
                }else {
                    //패스워드가 틀릴 경우
                    req.setAttribute("MSG", "패스워드가 일치하지않습니다");
                    req.getRequestDispatcher("/WEB-INF/member/password.jsp").forward(req, resp);
                    return;
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
