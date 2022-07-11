package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuthFilter implements Filter {

    Map<String, Integer> pageGrandeMap = new HashMap<>();
    public static boolean filterflag = false;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        pageGrandeMap.put("/Board/list.do", 0); // 모두 이용가능
        pageGrandeMap.put("/Board/post.do", 1); // 일반 계정권한이상

        pageGrandeMap.put("/Notice/list.do", 0); // 모두 이용가능
        pageGrandeMap.put("/Notice/post.do", 2); // 관리자 등급에서만 사용가능능
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        //Request 전 처리
        System.out.println("Filter 처리(Request 전)!!!");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        if(filterflag == true) {
            //Session으로부터 grade 추출
            HttpServletRequest request = (HttpServletRequest) req;
            HttpSession session = request.getSession();
            int usergrade = 0;
            if(session.getAttribute("grade") != null)
            usergrade = (Integer) session.getAttribute("grade");
            System.out.println("UserGrade : " + usergrade);

            //URL grade 확인
            String URL = request.getRequestURI();
            System.out.println("Filter's URL : " + URL);
            int pagegrade = 0;
            if(pageGrandeMap.get(URL) != null)
                pagegrade = pageGrandeMap.get(URL);
            System.out.println("PageGrade : " + pagegrade);
            //guest 계정이 1 이상 page로 접근 불가
            if(usergrade == 0 && pagegrade >= 1) throw new ServletException("신보근이 필요한 페이지입니다");

            //admin 계정
            if(usergrade < 2 && pagegrade == 2) throw new ServletException("신보근이 아닙니다");

        }
        filterflag = true;

        chain.doFilter(req, resp);

        //Response 전 처리
        System.out.println("Filter 처리(Response 전)!!!");


    }
}
