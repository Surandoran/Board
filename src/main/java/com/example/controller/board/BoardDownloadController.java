package com.example.controller.board;

import com.example.controller.SubController;
import com.example.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDownloadController implements SubController{

	BoardService service = BoardService.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//파라미터
		String filename=req.getParameter("filename");
		String flag = req.getParameter("flag"); //전체다운받기용 확인
		
		//입력값
		//서비스
		boolean result=false;
		result=service.download(filename, req, resp);
	 
		
		
		//View
		
		
	}

}
