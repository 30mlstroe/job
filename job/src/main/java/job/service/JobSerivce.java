package job.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import job.API.OpenAPI;
import job.API.XmlPasing;
import job.fileRead.ReadFile;
import job.model.elk.dao.ElasticSearchDAO;
import job.model.elk.dto.FaceBookDTO;
import job.model.elk.dto.HrdDTO;
import job.model.elk.dto.ResumeDTO;
import job.model.elk.dto.ScoreDTO;
import job.model.elk.dto.WeightDTO;
import job.model.elk.dto.WorknetDTO;
import job.model.joinus.dto.JoinUsDTO;
import job.recommend.analysis.Recommend;
import job.scraping.ScrapingPatten;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Service
public class JobSerivce {

	@Autowired
	OpenAPI api;

	@Autowired
	XmlPasing xml;

	@Autowired
	ElasticSearchDAO elk;

	@Autowired
	JobRecommendService jobRec;
	
	@Autowired
	ReadFile file;
	
	@Autowired
	Recommend rec;
	
	@Autowired
	ScrapingPatten patten;

	
	@SuppressWarnings("unchecked")
	public JSONObject createUserService(ResumeDTO user) throws IOException {
		JSONObject object = new JSONObject();
		if(!user.getJobName_type1().equals("null")) {
			user.setJobCode_type1(elk.readJobCodeNameDAO(user.getJobName_type1()));
		}else {
			user.setJobCode_type1("null");
		}
		if(!user.getJobName_type2().equals("null")) {
			user.setJobCode_type2(elk.readJobCodeNameDAO(user.getJobName_type2()));
		}else {
			user.setJobCode_type2("null");
		}
		if(!user.getJobName_type3().equals("null")) {
			user.setJobCode_type3(elk.readJobCodeNameDAO(user.getJobName_type3()));
		}else {
			user.setJobCode_type3("null");
		}
		object.put("userCreate", elk.creatUserDAO(user));
		
		if(user.getCareer_1().equals("null,null,null,null,null,null")) {
			user.setEnter_type("N");
			object.put("userTypeNewcomer", elk.userUpdateDAO(user));
		}
		else {
			user.setEnter_type("E");
			object.put("userTypeCareer", elk.userUpdateDAO(user));
		}
		return object;
		
	}
	
	public Result jobUserType(String id) throws ParserConfigurationException, SAXException, IOException, ParseException {
		ResumeDTO user = elk.readUserinfoDAO(id);
		if(user.getCareer_1().equals("null,null,null,null,null,null")) {
			user.setEnter_type("N");
			return elk.userUpdateDAO(user);
		}
		else {
			user.setEnter_type("E");
			return elk.userUpdateDAO(user);
		}
		
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public JSONObject createWorkNetListService(String code) throws ParserConfigurationException, SAXException, IOException {
		Integer total = (Integer.parseInt(xml.pasingJobTotal(api.getJobTotal(code))) / 100) + 1;
		ArrayList<WorknetDTO> work = null;
		JSONObject object = new JSONObject();
		ArrayList<Result> result = new ArrayList<>();
		for (int i = 1; i <= total; i++) {
			work = xml.pasingJobList(api.getJobList(i, code));
			if(work.size() == 0) {
				break;
			}
			result.add(elk.workNetIdbulk(work));
		}
		object.put("list result", result);
		return object;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getWorkNetDetail() throws ParserConfigurationException, SAXException, IOException {
		ArrayList<Result> result = new ArrayList<>();
		JSONObject object = new JSONObject();
		
		for (String e : elk.getWorkNetIds()) {
			result.add(elk.worknetUpdate(xml.pasingJobDetail(api.getJobDetail(e))));
		}
		object.put("detail", result);
		return object;
	}
	
	
	
	public Result recommenJobService(ResumeDTO user) throws IOException {
		
		user = elk.readUserinfoDAO(user.getUser_id());
		Result result = null;
		if(user.getEnter_type().equals("N")) {//신입
			result =  elk.recommendNewJobDAO(user);
		}else if(user.getEnter_type().equals("E")) {//경력
			result =  elk.recCareerMNCJobDAO(user);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject createCompanyNameService() throws IOException {
		JSONObject object = new JSONObject();
		object.put("first_work_time", elk.saveCompanyNameDAO(file.firstWorkTime(), "first_work_time"));
		object.put("second_work_time", elk.saveCompanyNameDAO(file.secondWorkTime(), "second_work_time"));
		object.put("first_work_info", elk.saveCompanyNameDAO(file.firstWorkInfo(), "first_work_info"));
		object.put("second_work_info", elk.saveCompanyNameDAO(file.secondWorkInfo(), "second_work_info"));
		object.put("foreign", elk.creatForeignCompanies());
		
		return object;
		
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject worknetCorpNmAllService() throws Exception {
		ArrayList<ScoreDTO> score = new ArrayList<>();
		JSONObject object = new JSONObject();
		for(WorknetDTO e : elk.worknetCorpNmAllDAO()) {
			score.add(new ScoreDTO(
					e.getWantedAuthNo(), 
					e.getCorpNm(), 
					rec.getSalLevle((double)e.getMinSal()), 
					rec.setWorkTime(e.getCorpNm()),
					rec.setWorkInfo(e.getCorpNm()),
					patten.getCity(e.getCorpAddr()),
					rec.getWorkbility(e.getEmpTpCd()),
					rec.setCareers(e.getCorpNm())
					));
		}
		object.put("companyName", elk.saveTestReqDAO(score));
		return object;
		
	}
	
	public void calculateScore() throws IOException {
		double result = 0;
		ScoreDTO userType = elk.getUserTypeScoreDAO("test1");
		for(ScoreDTO e : elk.findCompanyScoreDAO()) {
			result = (userType.getSalLevel() - e.getSalLevel()) + 
					(userType.getWorkTime() - e.getWorkTime()) + 
					(userType.getWorkInfo() - e.getWorkInfo()) ;
			System.out.println(result);
		}
	}
	
	public ScoreDTO updateUserTypeService(ResumeDTO resume) throws Exception {
		ScoreDTO userScore = new ScoreDTO();
		ArrayList<String> companNames = jobRec.getCompanyName(resume);
		double workTime = 0;
		double workInfo = 0;
		double careers = 0;
		
		userScore.setId(resume.getUser_id());
		userScore.setSalLevel(Double.parseDouble(resume.getGrade_money())/47008620.0);
		for(String e : companNames) {
			workTime = rec.setWorkTime(e) + workTime;
			workInfo = rec.setWorkInfo(e) + workInfo;
			careers = rec.setCareers(e)+ careers;
		}
		
		userScore.setWorkTime(workTime);
		userScore.setWorkInfo(workInfo);
		userScore.setDistance(patten.getUserCity(resume.getUser_addr1()));
		userScore.setWorkability(resume.getGuin_grade());
		userScore.setCareers(careers);
		return userScore;
		
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject creatUserTypeService(ScoreDTO user) throws IOException {
		JSONObject object = new JSONObject();
		object.put("userType", elk.creatUserTypeDAO(user));
		return object;
	}
	
	
	public Result creatUserWeightService(String id) throws IOException {
		WeightDTO user = new WeightDTO();
		user.setId(id);
		user.setSalLevel(0);
		user.setWorkTime(0);
		user.setWorkInfo(0);
		user.setDistance(0);
		user.setWorkability(0);
		user.setCareers(0);
		
		return elk.creatUserWeightDAO(user);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject createEducationService() throws IOException, ParserConfigurationException, SAXException {
		Integer total = (Integer.parseInt(xml.pasingEducationTotal(api.educationListAPI(1))) / 100) + 1;
		ArrayList<HrdDTO> hrd = null;
		JSONObject object = new JSONObject();
		ArrayList<Result> result = new ArrayList<>();
		for (int i = 1; i <= total; i++) {
			hrd = xml.pasingEducationList(api.educationListAPI(i));
			if(hrd.size() == 0) {
				break;
			}
			result.add(elk.Educationbulk(hrd));
		}
		object.put("result", result);
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray recommendEducationService(String id) throws Exception {
		ResumeDTO user = elk.readUserinfoDAO(id);
		if(user == null) {
			return null;
		}
		JSONArray result = new JSONArray();
		result.add(elk.recommendEducationDAO(
				patten.getUserEuduCity(user.getUser_addr1()), 
				elk.readNcsCodeDAO(user.getJobCode_type1()), 
				elk.readNcsCodeDAO(user.getJobCode_type2()), 
				elk.readNcsCodeDAO(user.getJobCode_type3())));
		return result;
	}
	
	public JSONArray readFacebookService() throws Exception {
		return elk.readFaceBookDAO();
	}
	
	public JSONArray readBlogService() throws Exception {
		return elk.readBlogDAO();
	}
	
	public ResumeDTO readResumeService(JoinUsDTO user) throws Exception {
		return elk.readUserinfoDAO(user.getUser_id());
	}
	
	public WeightDTO readWeightService(String id) throws Exception {
		return elk.readWeightDAO(id);
	}
}
