package com.example.service;

import com.example.dao.MemberDAO;
import com.example.dto.MemberDTO;
import org.mindrot.bcrypt.BCrypt;

public class MemberService {

    MemberDAO dao = MemberDAO.getInstance();
    public BCrypt passwordEncoder = new BCrypt();

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
        //패스워드 암호화
        String pwd = passwordEncoder.hashpw(dto.getPwd(), passwordEncoder.gensalt());
        System.out.println("PWD : " + pwd);
        dto.setPwd(pwd);
        return dao.insert(dto);
    }

    public MemberDTO MemberSearch(String email) {
        return dao.select(email);
    }

    public boolean MemberUpdate(MemberDTO dto) {
        return dao.Update(dto);
    }


}
