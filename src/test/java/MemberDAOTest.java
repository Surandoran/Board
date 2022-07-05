import com.example.dao.MemberDAO;
import com.example.dto.MemberDTO;
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

}
