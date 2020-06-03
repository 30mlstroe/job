package job.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.elasticsearch.ElasticsearchException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import job.encryptUtil.AES256Util;
import job.model.elk.dto.ResumeDTO;
import job.model.elk.dto.WeightDTO;
import job.model.joinus.dto.JoinUsDTO;
import job.model.joinus.dto.LoginSessionDTO;
import job.service.JobSerivce;
import job.service.SharpleService;

@SessionAttributes("user")
@CrossOrigin(origins = { "http://127.0.0.1:8000", "http://localhost:8000", "http://192.168.10.84:8000",
		"http://3.34.97.203:8000" })
@Controller
public class PageController {
	@Resource
	private LoginSessionDTO userSession;

	@Autowired
	SharpleService sharpleService;

	@Autowired
	JobSerivce jobService;
	
	@Autowired
	AES256Util ae;

	@GetMapping("/sharple")
	public String mainPage() throws Exception {
		return "redirect:/sharple.html";
	}

	@RequestMapping(value = "/userLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String userLogin(HttpServletRequest request, Model model)
			throws IOException, ElasticsearchException, NoSuchAlgorithmException, GeneralSecurityException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			HttpSession session = request.getSession(true);
			Object userInfo = (sharpleService.logInSharpleService(id, password));
			System.out.println("userLogin : "+userInfo);
			if (userInfo != null && !userInfo.equals("fail")) {
				session.setAttribute("user", userInfo);
				model.addAttribute("user", userInfo);
			} else if (userInfo.equals("fail")) {
				session.setAttribute("user", "로그인 실패");
				return "redirect:/404-page-one.html";
			}
		} catch (IOException | ElasticsearchException e) {
			e.printStackTrace();
		}

		return "main";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // HttpSession 로그인 일때 사용
		return "redirect:/sharple.html";
	}

	@GetMapping("/myPage")
	public ModelAndView myPage(HttpServletRequest request,  Model model) {
		HttpSession session = request.getSession(true);
		JoinUsDTO userInfo = (JoinUsDTO) session.getAttribute("user");
		
		System.out.println("mypage : "+userInfo);
		ModelAndView mv = new ModelAndView("/myPage");
		model.addAttribute("user", userInfo);
		session.setAttribute("user", userInfo);
		if (userInfo != null) {
			mv.addObject("userInfo", userInfo);
		}
		return mv;
	}

	@PostMapping("/updateUserInfo")
	public String updateUserInfo(HttpServletRequest request, Model model)
			throws NoSuchAlgorithmException, GeneralSecurityException {
		JoinUsDTO userUpdate = new JoinUsDTO();
		String nextPage = "redirect:/404-page-one.html";
		userUpdate.setUser_email(request.getParameter("userEmail"));
		userUpdate.setUser_id(request.getParameter("userId"));
		userUpdate.setUser_name(request.getParameter("userName"));
		userUpdate.setUser_phone(request.getParameter("userPhone"));
		userUpdate.setUser_pw(request.getParameter("password"));
		System.out.println("user update : "+userUpdate);
		try {
			HttpSession session = request.getSession(true);
			String updateResult = sharpleService.updateMyPageSharpleService(userUpdate);
			if (updateResult.equals("success")) {
				session.setAttribute("user", userUpdate);
				model.addAttribute("user", userUpdate);
				nextPage = "/main";
			} else if (updateResult.equals("NOOP")) {
				return nextPage;
			}
		} catch (IOException | ElasticsearchException e) {
			e.printStackTrace();
		}

		return nextPage;
	}

	@GetMapping("/createResume")
	public String createResume(HttpSession session) throws Exception {
		JoinUsDTO user = (JoinUsDTO)session.getAttribute("user");
		session.setAttribute("user", user);
		
		return "createResume";
	}

	@PostMapping("/saveResume")
	public String saveResume(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		ResumeDTO newResume = new ResumeDTO();
		JoinUsDTO userInfo = (JoinUsDTO) session.getAttribute("user");
		JSONObject saveResult = null;
		String nextPage = "";

		newResume.setUser_id(userInfo.getUser_id());
		// -------------- 기본정보 ----------------
		newResume.setUser_name(userInfo.getUser_name());
		newResume.setUser_type(request.getParameter("previousCareer")); // 이전 직장 대중소기업 previousCareer
		newResume.setTitle(request.getParameter("title")); // 이력서 제목
		newResume.setProfile(request.getParameter("profile")); // 경력사항 설명
		newResume.setUser_prefix(request.getParameter("sex")); // 성별
		newResume.setUser_age(request.getParameter("age"));
		newResume.setUser_jangae(request.getParameter("marry")); // 혼인여부
		newResume.setUser_army(request.getParameter("army"));
		newResume.setGrade_lastgrade(request.getParameter("finalGraduation")); // 최종학력 학사, 석사, 박사
		newResume.setGrade1_endYear(request.getParameter("graduatedYear")); // 졸업년도
		newResume.setGrade1_schoolName(request.getParameter("schoolName"));
		newResume.setGrade1_schoolEnd(request.getParameter("whetherGraduated")); // 졸업 여부
		newResume.setGrade1_schoolCity(request.getParameter("schoolRegion")); // 학교 소재지역
		// -------------- 연락처 ----------------
		newResume.setUser_hphone(userInfo.getUser_phone());
		newResume.setUser_email1(userInfo.getUser_email());
		newResume.setUser_zipcode(request.getParameter("zipcode")); // 우편번호
		newResume.setUser_addr1(request.getParameter("address1")); // 주소
		newResume.setUser_addr2(request.getParameter("address2")); // 상세주소
		// -------------- 원하는 직종 정보 ----------------
		newResume.setJobName_type1(request.getParameter("jobName1"));// 희망 직종 이름
		newResume.setJobName_type2(request.getParameter("jobName2"));
		newResume.setJobName_type3(request.getParameter("jobName3"));
		newResume.setGrade_gtype(request.getParameter("employmentType")); // 희망 고용 형태
		newResume.setGrade_money(request.getParameter("hopeSalary").toString()+"0000"); // 희망 급여 액
		newResume.setGrade_money_type("연봉"); // 수입의 형태 (연봉, 월급)
		newResume.setHopeSize(request.getParameter("hopeCompanySize")); // 희망 회사 규모
		newResume.setGuin_grade(request.getParameter("employmentType")); // 정규직, 계약직 등
		newResume.setEnter_type(request.getParameter("enterType")); // 희망 직급 (대리, 사원 , 부장 등)
		// -------------- 스킬 정보 ----------------
		newResume.setSkill_word(request.getParameter("wordSkill")); // 상중하
		newResume.setSkill_ppt(request.getParameter("pptSkill"));
		newResume.setSkill_excel(request.getParameter("excelSkill"));
		newResume.setSkill_search(request.getParameter("searchingSkill"));
		newResume.setSkill_list(request.getParameter("certificationList")); // 자격증 취득 리스트
		// -------------- 경력 정보 ----------------
		newResume.setCareer_1(
				request.getParameter("startWorkMonth1") + "," + 
						request.getParameter("exitWorkMonth1") + "," + 
						request.getParameter("careerCompany1") + "," + 
						request.getParameter("careerPart1") + "," + 
						request.getParameter("careerPosition1"));
		newResume.setCareer_2(
				request.getParameter("startWorkMonth2") + "," + 
						request.getParameter("exitWorkMonth2") + "," + 
						request.getParameter("careerCompany2") + "," + 
						request.getParameter("careerPart2") + "," + 
						request.getParameter("careerPosition2"));
		newResume.setCareer_3(
				request.getParameter("startWorkMonth3") + "," + 
						request.getParameter("exitWorkMonth3") + "," + 
						request.getParameter("careerCompany3") + "," + 
						request.getParameter("careerPart3") + "," + 
						request.getParameter("careerPosition3"));
		newResume.setCareer_4(
				request.getParameter("startWorkMonth4") + "," + 
						request.getParameter("exitWorkMonth4") + "," + 
						request.getParameter("careerCompany4") + "," + 
						request.getParameter("careerPart4") + "," + 
						request.getParameter("careerPosition4"));
		newResume.setProfile(request.getParameter("profile").toString());
		try {
			saveResult = jobService.createUserService(newResume);
			if (saveResult.get("userCreate").toString().equals("CREATED")
					|| saveResult.get("userCreate").toString().equals("UPDATED")
					|| saveResult.get("userTypeCareer").toString().equals("CREATED")
					|| saveResult.get("userTypeCareer").toString().equals("UPDATED")) {
				jobService.creatUserTypeService(jobService.updateUserTypeService(newResume));
				
				nextPage = "createWeight";
			} else {
				return "/404-page-one.html";
			}
		} catch (IOException | ElasticsearchException e) {
			e.printStackTrace();
		}

		return nextPage;
	}
	
	@GetMapping("/createWeight")
	public String createWeight(HttpSession session) throws Exception {
		if (session.getAttribute("user") != null) {
			return "createWeight";

		} else {
			return "redirect:/sharple.html";
		}
	}
	
	@GetMapping("/saveWeight")
	public String saveeWeight(HttpSession session) throws Exception {
		if (session.getAttribute("user") != null) {
			return "main";

		} else {
			return "redirect:/sharple.html";
		}
	}

	@GetMapping("/myResume")
	public ModelAndView myResume(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession(true);
		JoinUsDTO userInfo = (JoinUsDTO) session.getAttribute("user");
		WeightDTO weight = jobService.readWeightService(userInfo.getUser_id());
		ModelAndView mv = new ModelAndView("/myResume");
		model.addAttribute("weight", weight);
		if (userInfo != null) {
			mv.addObject("userInfo", userInfo);
		}
		return mv;
	}

	@GetMapping("/main")
	public String moveMain(HttpSession session) throws Exception {
		System.out.println(session.getAttribute("user"));
		if (session.getAttribute("user") != null) {
			JoinUsDTO userInfo = (JoinUsDTO) session.getAttribute("user");
			System.out.println(userInfo);
			return "main";

		} else {
			return "redirect:/sharple.html";
		}
	}

	@PostMapping("/updateResume")
	public String updateResume() throws Exception {
		return "main";
	}

	@RequestMapping("/facebook")
	public String readFaceBook(HttpSession session) throws Exception {
		JoinUsDTO user = (JoinUsDTO) session.getAttribute("user");
		if (user != null) {
			return "facebook";

		} else {
			return "redirect:/sharple.html";
		}
	}

	@RequestMapping("/blog")
	public String readblog(HttpSession session) throws Exception {
		JoinUsDTO user = (JoinUsDTO) session.getAttribute("user");
		if (user != null) {
			return "blog";

		} else {
			return "redirect:/sharple.html";
		}
	}

	@GetMapping("/regist")
	public String registPage() throws Exception {
		return "register";
	}

	@RequestMapping("/resumeDetail")
	public String readResume(HttpSession session) throws Exception {
		JoinUsDTO user = (JoinUsDTO) session.getAttribute("user");
		if (user != null) {
			return "resumeDetail";

		} else {
			return "redirect:/login.html";
		}
	}
	
	@RequestMapping("/updateWeight")
	public String updateWeight(HttpServletRequest request, HttpSession session) throws Exception {
		JoinUsDTO user = (JoinUsDTO) session.getAttribute("user");
		if (user != null) {
			System.out.println(request.getParameter("careers"));
			return "/myResume";

		} else {
			return "redirect:/login.html";
		}
	}

}
