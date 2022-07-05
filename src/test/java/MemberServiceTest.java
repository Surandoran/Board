import com.example.dto.MemberDTO;
import com.example.service.MemberService;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    @Test
    public void test() {
        MemberDTO dto = new MemberDTO();
        dto.setEmail("example2@example.com");
        dto.setPwd("1234");
        dto.setAddr1("대구");
        dto.setAddr2("대구");

        MemberService service = MemberService.getInstance();
        service.MemberInsert(dto);
    }
}
