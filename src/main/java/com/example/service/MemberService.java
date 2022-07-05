package com.example.service;

import com.example.dao.MemberDAO;
import com.example.dto.MemberDTO;

public class MemberService {

    MemberDAO dao = MemberDAO.getInstance();

    //싱글톤 패턴
    private static MemberService instance = null;

    public static MemberService getInstance() {
        if(instance == null) {
            instance = new MemberService();
        }
        return instance;
    }
    private MemberService() {

    }

    public boolean MemberInsert(MemberDTO dto) {
        return dao.insert(dto);
    }

}
