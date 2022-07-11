package com.example.service;

import com.example.dao.BoardDAO;
import com.example.dao.MemberDAO;
import com.example.dto.BoardDTO;
import org.mindrot.bcrypt.BCrypt;

import java.util.List;

public class BoardService {

    BoardDAO dao = BoardDAO.getInstance();

    //싱글톤 패턴
    private static BoardService instance = null;

    public static BoardService getInstance() {
        if(instance == null) {
            instance = new BoardService();
        }
        return instance;
    }
    private BoardService() {

    }
    public List<BoardDTO> getBoardList(int start, int end) {
        return dao.Select(start, end);
    }

}
