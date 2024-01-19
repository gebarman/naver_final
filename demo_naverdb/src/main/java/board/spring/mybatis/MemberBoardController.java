package board.spring.mybatis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import jakarta.servlet.http.HttpSession;

@Controller
public class MemberBoardController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@GetMapping("/boardlogin")
	public String loginForm() {
		return "board/loginform";
	}
	
	@PostMapping("/boardlogin")
	String loginProcess(String memberid, String pw, HttpSession session){
		
		MemberDTO dto = service.oneMember(memberid);
		if(dto != null) {
			if(dto.getPw().equals(pw)) {
				//정상 로그인
				session.setAttribute("sessionid", memberid);
			}else {
				//암호 다른 경우
			}
		}else {
			//id 존재 x
		}
		return "board/start";
	}
	@RequestMapping("/boardlogout")
	String logout(HttpSession session){
		if(session.getAttribute("sessionid") != null) {
			session.removeAttribute("sessionid");
		}
		return "board/start";
		
	}
	
}
