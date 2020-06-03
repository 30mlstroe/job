package job.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse.Result;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import job.model.elk.dto.ResumeDTO;
import job.model.elk.dto.WeightDTO;
import job.model.joinus.dto.JoinUsDTO;
import job.service.JobSerivce;
import job.service.ScrapingService;
import job.service.SharpleService;

@RestController
@CrossOrigin(origins = { "http://127.0.0.1:8000", "http://localhost:8000", "http://192.168.10.84:8000", "http://3.34.97.203:8000"})
public class JobSearchRestController {

	@Autowired
	JobSerivce js;
	@Autowired
	ScrapingService sc;
	
	@Autowired
	SharpleService sharpleService;
	
	//워크넷 api 콜 및 ES에 저장
	@SuppressWarnings({ "unchecked"})
	@PostMapping("/createtworknet")
	public JSONArray createWorkNetAPI() throws Exception {
		//024, 025
		System.out.println("start createtworknet");
		JSONArray dataArray = new JSONArray();
		dataArray.add(js.createWorkNetListService("024"));
		dataArray.add(js.createWorkNetListService("025"));
		dataArray.add(js.createWorkNetListService("026"));
		dataArray.add(js.getWorkNetDetail());
		dataArray.add(js.worknetCorpNmAllService());
		System.out.println("End createtworknet");
		return dataArray;
	}
	
	
	//유저 추가
//	@SuppressWarnings("unchecked")
//	@PostMapping("/createUser")
//	public JSONArray createUserController(ResumeDTO user) throws Exception {
//		JSONArray dataArray = new JSONArray();
//		dataArray.add(js.createUserService(user));
//		dataArray.add(js.creatUserTypeService(js.updateUserTypeService(user.getUser_id())));
//		return dataArray;
//	}
	
	//이전 직업 추천
	@PostMapping("/recommandJob")
	public Result recommendJob(ResumeDTO user) throws IOException, ParseException, ParserConfigurationException, SAXException {
		return js.recommenJobService(user);
	}
	
	//블로그, 페이스북 스크래핑 후 저장
	@PostMapping("/blogScraping")
	public Result blogScraping() throws Exception {
		return sc.blogScrapingService();
	}
	
	@PostMapping("/faceBookScraping")
	public Result faceBookScraping() throws Exception {
		return sc.faceBookScrapingService();
	}
	
	//점수용 회사이름 저장
	@PostMapping("/companyName")
	public JSONObject saveCompanyName() throws IOException {
		return js.createCompanyNameService();
	}
	
	@PostMapping("/createUserWeight")
	public Result createUserWeight(WeightDTO data) throws Exception {
		return js.creatUserWeightService(data.getId());
	}
	
	@PostMapping("/analisysJob")
	public void analisysJob() throws IOException {
		js.calculateScore();
	}
	
	@PostMapping("/createEducation")
	public JSONObject createEducation() throws IOException, ParserConfigurationException, SAXException {
		return js.createEducationService();
	}
	
	@PostMapping("/recommendEducation")
	public JSONArray recommendEducation(HttpSession session) throws Exception {
		JoinUsDTO user = (JoinUsDTO)session.getAttribute("user");
		return js.recommendEducationService(user.getUser_id());
	}
	
	@PostMapping("/readFaceBook")
	public JSONArray readFaceBook() throws Exception {
		return js.readFacebookService();
	}
	
	@PostMapping("/readBlog")
	public JSONArray readBlog() throws Exception {
		return js.readBlogService();
	}
	
	@PostMapping("/readWeight")
	public WeightDTO readWeight(HttpSession session) throws Exception {
		JoinUsDTO user = (JoinUsDTO)session.getAttribute("user");
		return js.readWeightService(user.getUser_id());
	}
	
	@PostMapping("/readResume")
	public ResumeDTO readResume(HttpSession session) throws Exception {
		JoinUsDTO user = (JoinUsDTO)session.getAttribute("user");
		return js.readResumeService(user);
	}
	
	@PostMapping("/sharpleRegister")
	public String userRegister(@RequestBody ArrayList<Map<String, String>> params)
			throws IOException, ElasticsearchException, NoSuchAlgorithmException, GeneralSecurityException {

		JoinUsDTO newUser = new JoinUsDTO();
		Map<String, String> param = new HashMap<String, String>();
		Map<String, String> user = new HashMap<String, String>();
		String result = "fail";
		for (int i = 0; i < params.size(); i++) {
			for (Entry<String, String> elem : params.get(i).entrySet()) {
				param.put(elem.getKey(), elem.getValue());
			}
			user.put(param.get("name"), param.get("value"));
		}
		newUser.setUser_id(user.get("userId"));
		newUser.setUser_name(user.get("userName"));
		newUser.setUser_email(user.get("userEmail"));
		newUser.setUser_phone(user.get("userPhone"));
		newUser.setUser_pw(user.get("userPassword"));
		try {
			result = sharpleService.registSharpleService(newUser);
			js.creatUserWeightService(newUser.getUser_id());
			if (result.equals("Succeeded")) {
				return "Succeeded";
			} else if (result.equals("Fail")) {
				return "Fail";
			}else if (result.equals("ID")) {
				return "ID";
			}

		} catch (IOException | ElasticsearchException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
