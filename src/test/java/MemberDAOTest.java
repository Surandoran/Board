import com.example.dao.MemberDAO;
import com.example.dto.MemberDTO;
import com.example.service.MemberService;
import org.junit.jupiter.api.Test;

public class MemberDAOTest {

    @Test
    public void test(){
        MemberDTO dto = new MemberDTO();
        dto.setEmail("example@example.com");
        dto.setPwd("1234");
        dto.setAddr1("대구 광역시 달서구 000");
        dto.setAddr2("00아파트 000동 0000호");

        MemberDAO dao = MemberDAO.getInstance();
        boolean result = dao.insert(dto);
        if(result) {
            System.out.println("인쎁성공");
        } else{
            System.out.println("인쎁실패");
        }
    }

    @Test
    public void Test2() {
        //MemberDAO's Select(email)
        MemberDAO dao = MemberDAO.getInstance();
        MemberDTO dto = dao.select("example@example.com");
        System.out.println("결과 : " + dto.toString());

    }

    @Test
    public void Test3() {
        MemberDTO dto = new MemberDTO();
        dto.setEmail("example@example.com");
        dto.setPwd("0987");
        dto.setAddr1("서울특별실");
        dto.setAddr2("00구 00동");

        MemberDAO dao = MemberDAO.getInstance();
        dao.Update(dto);

    }

    @Test
    public void Test4() {
        MemberDTO dto = new MemberDTO();
        dto.setEmail("admin@admin.com");
        dto.setPwd("1234");
        dto.setAddr1("");
        dto.setAddr2("");
        dto.setGrade(2);

        MemberService memberService = MemberService.getInstance();
        memberService.MemberInsert(dto); // 관리자 계정 등록

        dto.setEmail("guest@guest.com");
        dto.setPwd("1234");
        dto.setAddr1("");
        dto.setAddr2("");
        dto.setGrade(0);

        memberService.MemberInsert(dto);
    }

}
