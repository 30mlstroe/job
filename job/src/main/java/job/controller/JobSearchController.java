package job.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import job.model.joinus.dto.LoginSessionDTO;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "http://127.0.0.1:8000", "http://localhost:8000", "http://192.168.10.84:8000", "http://3.34.97.203:8000"})
@Controller
public class JobSearchController {
	@Resource
	private LoginSessionDTO userSession;
	
	@RequestMapping("/sample")
	public String sample() {
		return "Sample";
	}
	
	@RequestMapping("/juso2")
	public String juso() {
		return "jusoPopup";
	}
	
//	@RequestMapping("test2")
//	public String test2(HttpServletRequest request, Model model) {
//		JoinUsDTO newUser = new JoinUsDTO();
//		HttpSession session = request.getSession(true);
////		session.setAttribute("user", userInfo);
////		model.addAttribute("user", userInfo);
//		return "test2";
//	}

}
