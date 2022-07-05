package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
SubController Interface
회원가입 컨트롤러 (서브)
인증 컨트롤러(서브)
게시판 컨트롤러(서브)
 */

public interface SubController {

    void execute(HttpServletRequest req, HttpServletResponse resp);

}
