package com.example.dao;

import com.example.dto.BoardDTO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    //DB연결
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String id = "book_ex";
    private String pw = "1234";

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    //SingleTon Pattern
    private static BoardDAO instance;

    public static BoardDAO getInstance() {
        if (instance == null)
            instance = new BoardDAO();
        return instance;
    }

    private BoardDAO() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,id,pw);
            System.out.println("DBConnected..");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // 시작페이지, 끝페이지 번호 받아서 조회
    public List<BoardDTO> Select(int start, int end)
    {
        ArrayList<BoardDTO> list = new ArrayList<>();
        BoardDTO dto = null;
        try {
            String sql =
                    "select rownum rn, no , title, content, writer, regdate, pwd, count, ip, filename, filesize"
                            + " from"
                            + "("
                            + "    select /*+ INDEX_DESC (tbl_board PK_NO) */"
                            + "    rownum rn, no , title, content, writer, regdate, pwd, count, ip, filename, filesize "
                            + "    from tbl_board where rownum <= ?"
                            + ")"
                            + " where rn >= ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                dto = new BoardDTO();
                dto.setNo(rs.getInt("no"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriter(rs.getString("writer"));
                dto.setRegdate(rs.getString("regdate"));
                dto.setPwd(rs.getString("pwd"));
                dto.setIp(rs.getString("ip"));
                dto.setFilename(rs.getString("filename"));
                dto.setFilesize(rs.getString("filesize"));
                dto.setCount(rs.getInt("count"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //모든 게시물 개수 조회
    public int getTotalCount() {
        int result = 0;
        try {

            pstmt = conn.prepareStatement("select count(*) from tbl_board");
            rs = pstmt.executeQuery();
            rs.next(); // 한번 내려감 첫번째 나오는 열의 값을 int
            result = rs.getInt(1); // 잡아서 담는다


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean Insert(BoardDTO dto) {

        try {
            pstmt = conn.prepareStatement("insert into tbl_board values(tbl_board_seq.NEXTVAL,?,?,?,sysdate,?,0,?,?,?)");
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getWriter());
            pstmt.setString(4, dto.getPwd());
            pstmt.setString(5, dto.getIp());
            pstmt.setString(6, dto.getFilename());
            pstmt.setString(7, dto.getFilesize());

            int result = pstmt.executeUpdate();

            if(result > 0) {
                return true;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{pstmt.close();}catch (Exception e) {e.printStackTrace();}}
        return false;
    }

}
