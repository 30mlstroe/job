package job.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.elasticsearch.ElasticsearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import job.model.joinus.dto.JoinUsDTO;
import job.service.SharpleService;

@RestController
@CrossOrigin(origins = { "http://127.0.0.1:8000", "http://localhost:8000", "http://192.168.10.84:8000", "http://3.34.97.203:8000"})
public class SharpleController {
	
	@Autowired
	SharpleService sharpleService;
	
	//회원가입
	@PostMapping("/userRegister")
	public String userRegister(JoinUsDTO newUser) throws IOException, ElasticsearchException, NoSuchAlgorithmException, GeneralSecurityException{
		System.out.println(newUser.getUser_email());
		sharpleService.registSharpleService(newUser);
		return "redirect:/sharple.html";
	}
	
	//로그인
//	@GetMapping("/userLogin")
//	public Object userLogin(String email, String password) throws IOException, ElasticsearchException, NoSuchAlgorithmException, GeneralSecurityException{
//		String a = "sharpletest@shaple.net";
//		String b = "1234";
//		return sharpleService.logInSharpleService(email, password);
//	}

	//마이페이지(페이지의 버튼을 누를 시 페이지내의 유일한 식별자인 email로 JoinUsDTO 꺼내오기)
//	@GetMapping("/myPage")
//	public JoinUsDTO myPage(String email) throws IOException, ElasticsearchException{
//		return sharpleService.myPageSharpleService(email);
//	}
	
	//회원정보 수정 
	@GetMapping("/myPageUpdate")
	public String myPageUpdate(JoinUsDTO newUserInfo) throws IOException, ElasticsearchException, NoSuchAlgorithmException, GeneralSecurityException{
		return sharpleService.updateMyPageSharpleService(newUserInfo);
	}
	

}
