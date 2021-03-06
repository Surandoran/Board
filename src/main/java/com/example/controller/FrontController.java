package com.example.controller;

import com.example.controller.auth.LoginController;
import com.example.controller.auth.LogoutController;
import com.example.controller.board.*;
import com.example.controller.member.MemberInfoController;
import com.example.controller.member.MemberJoinController;
import com.example.controller.member.MemberUpdateController;
import com.example.controller.notice.NoticeListController;
import com.example.controller.notice.NoticePostController;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@MultipartConfig
(
		fileSizeThreshold=1024*1024*10,		//10Mb
		maxFileSize=1024*1024*50,			//50Mb
		maxRequestSize=1024*1024*100		//100Mb
)
public class FrontController extends HttpServlet{
	//URL : SubController객체주소
	HashMap <String,SubController> list = null;
		
	@Override
	public void init() throws ServletException {
		 list = new HashMap();
		 
		 //회원관련
		 list.put("/MemberJoin.do", new MemberJoinController());
		 list.put("/MemberInfo.do", new MemberInfoController());
		 list.put("/MemberUpdate.do", new MemberUpdateController());
		 
		 //인증관련
		 list.put("/Login.do", new LoginController());
		 list.put("/Logout.do", new LogoutController());
		 
		 //게시판관련
		 list.put("/Board/list.do", new BoardListController());
		 list.put("/Board/post.do", new BoardPostController());
		 list.put("/Board/read.do", new BoardReadController());
		 list.put("/Board/download.do", new BoardDownloadController());
		 list.put("/Board/downloadAll.do", new BoardDownloadAllController());
		 list.put("/Board/update.do", new BoardUpdateController());
		 list.put("/Board/delete.do", new BoardDeleteController());
		 list.put("/Board/replypost.do", new BoardReplypostController());
		 list.put("/Board/replylist.do", new BoardReplylistController());
		 list.put("/Board/replycnt.do", new BoardReplycntController());
		
			 
			 
		 //공지사항
		 list.put("/Notice/list.do", new NoticeListController());
		 list.put("/Notice/post.do", new NoticePostController());
		 
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String url = req.getRequestURI();
		System.out.println("URL : " + url);
		SubController sub=list.get(url);
		if(sub!=null)
			sub.execute(req, resp);
	}



	
	
}
