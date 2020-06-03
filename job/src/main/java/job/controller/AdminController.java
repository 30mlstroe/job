package job.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.elasticsearch.ElasticsearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import job.model.joinus.dto.JoinUsDTO;
import job.model.joinus.dto.LoginSessionDTO;
import job.service.SharpleService;

@Controller
@CrossOrigin(origins = { "http://127.0.0.1:8000", "http://localhost:8000", "http://192.168.10.84:8000", "http://3.34.97.203:8000"})
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private LoginSessionDTO userSession;
	
	@Autowired
	SharpleService sharpleService;
	
	public AdminController() {
		System.out.println("========AdminController==========");
		
	}
	
	@RequestMapping("/")
	public String test() {
		return "redirect:dist/adminLogin.html";
	}
	
	@RequestMapping(value= "/adminLogin", method =  {RequestMethod.GET, RequestMethod.POST})
	public String adminLogin(HttpServletRequest request, HttpSession session, Model model)
									throws IOException, ElasticsearchException{
	
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		JoinUsDTO userInfo = sharpleService.adminLogInService(user_id, password);
		if(userInfo != null && userInfo.getUser_id().equals(user_id)) {

			request.setAttribute("msg", "로그인 성공");
			session.setAttribute("user", userInfo);
			model.addAttribute("user", userInfo);
			return "redirect:dist/index.html";
		}
		else {
			request.setAttribute("msg", "로그인 실패");
			return "redirect:dist/loginError.html";
		}
	}
}
