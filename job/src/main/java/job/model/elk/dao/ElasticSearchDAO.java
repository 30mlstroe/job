package job.model.elk.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.search.SearchHit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import job.fileRead.ReadFile;
import job.model.elk.dto.FaceBookDTO;
import job.model.elk.dto.HrdDTO;
import job.model.elk.dto.JKDataDTO;
import job.model.elk.dto.ResumeDTO;
import job.model.elk.dto.ScoreDTO;
import job.model.elk.dto.WeightDTO;
import job.model.elk.dto.WorknetDTO;

@Component
public class ElasticSearchDAO {

	@Autowired
	ElasticSearchRequest req;

	@Autowired
	ElasticSearchResponse rep;
	
	@Autowired
	ReadFile file;
	
	public Result Educationbulk(ArrayList<HrdDTO> edu) throws IOException {
		return rep.createBulkRep(req.creatEucationBulkReq(edu));
	}
	
	public Result workNetIdbulk(ArrayList<WorknetDTO> id) throws IOException {
		return rep.createBulkRep(req.createWorknetIdReq(id));
	}
	
	public ArrayList<String> getWorkNetIds() throws IOException {
		return rep.worknetIdSearchRep(req.readWorknetIdSearchReq());
	}
	
	public Result worknetUpdate(WorknetDTO worknet) throws IOException {
		if(worknet.getWantedAuthNo().equals("null")) {
			return null;
		}
		return rep.updatePostRep((req.updateWorkNetDetailReq(worknet)));
	}
	
	
	public Result creatForeignCompanies() throws IOException {
		return rep.createBulkRep(req.createFComReq(file.getForeignCompanies()));
	}
	
	public Result creatUserDAO(ResumeDTO user) throws IOException {
		return rep.createUserRep(req.creatUserReq(user));
	}
	
	public ArrayList<String> findAllUserTypeDAO() throws IOException {
		ArrayList<String> userIds = new ArrayList<>();
		 for(SearchHit e : rep.searchRep(req.readUserTypeSearchReq())) {
			 userIds.add(e.getId());
		 }
		 return userIds;
	}
	
	public ResumeDTO readUserinfoDAO(String id) throws IOException {
		Map<String, Object> userInfo = rep.getUserTypeScoreRep(req.readUserinfoReq(id)).getSourceAsMap();
		if(userInfo == null) return null;
		ResumeDTO result = new ResumeDTO();
		result.setUser_name(userInfo.get("user_name").toString());
		result.setUser_id(userInfo.get("user_id").toString());
		result.setUser_type(userInfo.get("user_type").toString());
		result.setTitle(userInfo.get("title").toString());
		result.setProfile(userInfo.get("profile").toString());
		result.setUser_prefix(userInfo.get("user_prefix").toString());
		result.setUser_age(userInfo.get("user_age").toString());
		result.setUser_hphone(userInfo.get("user_age").toString());
		result.setUser_email1(userInfo.get("user_email1").toString());
		result.setUser_zipcode(userInfo.get("user_zipcode").toString());
		result.setUser_addr1(userInfo.get("user_addr1").toString());
		result.setUser_addr2(userInfo.get("user_addr2").toString());
		result.setUser_jangae(userInfo.get("user_jangae").toString());
		result.setUser_army(userInfo.get("user_army").toString());
		result.setJobCode_type1(userInfo.get("job_code_type1").toString());
		result.setJobCode_type2(userInfo.get("job_code_type2").toString());
		result.setJobCode_type3(userInfo.get("job_code_type3").toString());
		result.setJobName_type1(userInfo.get("job_name_type1").toString());
		result.setJobName_type2(userInfo.get("job_name_type2").toString());
		result.setJobName_type3(userInfo.get("job_name_type3").toString());
		result.setGrade_gtype(userInfo.get("grade_gtype").toString());
		result.setGrade_money(userInfo.get("grade_money").toString());
		result.setGrade_money_type(userInfo.get("grade_money_type").toString());
		result.setGrade_lastgrade(userInfo.get("grade_lastgrade").toString());
		result.setGrade1_endYear(userInfo.get("grade1_endYear").toString());
		result.setGrade1_schoolName(userInfo.get("grade1_schoolName").toString());
		result.setGrade1_schoolEnd(userInfo.get("grade1_schoolEnd").toString());
		result.setGrade1_schoolCity(userInfo.get("grade1_schoolCity").toString());
		result.setSkill_word(userInfo.get("skill_word").toString());
		result.setSkill_ppt(userInfo.get("skill_ppt").toString());
		result.setSkill_excel(userInfo.get("skill_excel").toString());
		result.setSkill_search(userInfo.get("skill_search").toString());
		result.setSkill_list(userInfo.get("skill_list").toString());
		result.setHopeSize(userInfo.get("HopeSize").toString());
		result.setCareer_1(userInfo.get("career_1").toString());
		result.setCareer_2(userInfo.get("career_2").toString());
		result.setCareer_3(userInfo.get("career_3").toString());
		result.setCareer_4(userInfo.get("career_4").toString());
		result.setGuin_grade(userInfo.get("guin_grade").toString());
		result.setEnter_type(userInfo.get("enter_type").toString());
			return result;
	}
	
	public Result userUpdateDAO(ResumeDTO user) {
		return rep.updatePostRep((req.updateResumeReq(user)));
	}
		
	public Result JKDataBulkDAO(ArrayList<JKDataDTO> data) throws IOException {
		return rep.createBulkRep(req.createCrawlingDataReq(data));
	}
	
	public Result FBBulkDAO(ArrayList<FaceBookDTO> data) throws IOException {
		return rep.createBulkRep(req.createFBDataReq(data));
	}
	
	public Result saveCompanyNameDAO(ArrayList<String> data, String index) throws IOException {
		return rep.createBulkRep(req.createCompanyNameReq(data, index));
	}
	
	public Result saveTestReqDAO(ArrayList<ScoreDTO> data) throws IOException {
		return rep.createBulkRep(req.createTestReq(data));
	}
	
	public ArrayList<WorknetDTO> worknetCorpNmAllDAO() throws IOException {
		return rep.worknetCorpNmAllRep(req.readWorknetIdSearchReq());
	}
	
	public Result recommendNewJobDAO(ResumeDTO data) throws IOException {
		return rep.updatePostRep(req.updateResumeReq(data));
	}
	
	public Result recCareerMNCJobDAO(ResumeDTO data) throws IOException {
		return rep.updatePostRep(req.updateResumeReq(data));
	}
	
	public double findCompanyNameDAO(String index, String name) throws IOException {
		ArrayList<String> userIds = new ArrayList<>();
		double result = 0;
		 for(SearchHit e : rep.searchRep(req.readCompanyNameReq(index, name))) {
			 userIds.add(e.getId());
		 }
		 if(userIds.size() > 0) {
			 result = 0.5;
		 }
		 return result;
	}
	
	public ScoreDTO getUserTypeScoreDAO(String id) throws IOException {
		ScoreDTO userType = new ScoreDTO();
		GetResponse respons = rep.getUserTypeScoreRep(req.readGetUserTypeScoreReq(id));
		userType.setId(id);
		userType.setSalLevel((double)respons.getSource().get("salLevel"));
		userType.setWorkTime((double)respons.getSource().get("workTime"));
		userType.setWorkInfo((double)respons.getSource().get("workInfo"));
		userType.setWorkability((String) respons.getSource().get("workability"));
		
		
		return userType;
	}
	
	public ArrayList<ScoreDTO> findCompanyScoreDAO() throws IOException {
		ArrayList<ScoreDTO> CompanyScores = new ArrayList<>();
		for(SearchHit e : rep.searchRep(req.readCompanyScoreReq())) {
			ScoreDTO score = new ScoreDTO();
			Map<String, Object> map = e.getSourceAsMap();
			score.setName(map.get("name").toString());
			score.setSalLevel((double)map.get("salLevel"));
			score.setWorkTime((double)map.get("workTime"));
			score.setWorkInfo((double)map.get("workInfo"));
			score.setWorkability((String)map.get("workability"));
			CompanyScores.add(score);
		}
		return CompanyScores;
	}
	
//	public ArrayList<ResumeDTO> findUserDAO() throws IOException {
//		ArrayList<ResumeDTO> resumes = new ArrayList<>();
//		for(SearchHit e : rep.searchRep(req.readUserReq())) {
//			Map<String, Object> userInfo = e.getSourceAsMap();
//			resumes.add(new ResumeDTO(
//					userInfo.get("user_id").toString(), 
//					userInfo.get("user_name").toString(),
//					userInfo.get("user_type").toString(),
//					userInfo.get("title").toString(),
//					userInfo.get("profile").toString(),
//					userInfo.get("user_prefix").toString(),
//					userInfo.get("user_age").toString(),
//					userInfo.get("user_hphone").toString(),
//					userInfo.get("user_email1").toString(),
//					userInfo.get("user_zipcode").toString(),
//					userInfo.get("user_addr1").toString(),
//					userInfo.get("user_addr2").toString(),
//					userInfo.get("user_jangae").toString(),
//					userInfo.get("user_army").toString(),
//					userInfo.get("job_type1").toString(),
//					userInfo.get("job_type2").toString(),
//					userInfo.get("job_type3").toString(),
//					userInfo.get("grade_gtype").toString(),
//					userInfo.get("grade_money").toString(),
//					userInfo.get("grade_money_type").toString(),
//					userInfo.get("grade_lastgrade").toString(),
//					userInfo.get("grade1_endYear").toString(),
//					userInfo.get("grade1_schoolName").toString(),
//					userInfo.get("grade1_schoolEnd").toString(),
//					userInfo.get("grade1_schoolCity").toString(),
//					userInfo.get("skill_word").toString(),
//					userInfo.get("skill_ppt").toString(),
//					userInfo.get("skill_excel").toString(),
//					userInfo.get("skill_search").toString(),
//					userInfo.get("skill_list").toString(),
//					userInfo.get("HopeSize").toString(),
//					userInfo.get("career_1").toString(),
//					userInfo.get("career_2").toString(),
//					userInfo.get("career_3").toString(),
//					userInfo.get("career_4").toString(),
//					userInfo.get("guin_grade").toString(),
//					userInfo.get("enter_type").toString()));
//			
//		}
//		return resumes;
//	}
	
	public Result creatUserTypeDAO(ScoreDTO user) throws IOException {
		return rep.createUserRep(req.creatUserTypeReq(user));
	}
	
	public Result creatUserWeightDAO(WeightDTO user) throws IOException {
		return rep.createUserRep(req.creatUserWeightReq(user));
	}
	
	public String readJobCodeNameDAO(String jobName) throws IOException {
		return rep.searchRep(req.readJobCodeNameReq(jobName)).getAt(0).getSourceAsMap().get("worknet_code").toString();
	}
	
//	public String readWornetCountDAO(String jobName) throws IOException {
//		return rep.searchRep(req.readJobCodeNameReq(jobName)).getAt(0).getSourceAsMap().get("worknet_code").toString();
//	}
	
	public String readNcsCodeDAO(String code) throws IOException {
		return rep.searchRep(req.readNcsCodeReq(code)).getAt(0).getSourceAsMap().get("ncs_code").toString();
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray recommendEducationDAO(String address, String ncsCd1, String ncsCd2, String ncsCd3) throws IOException {
		//ArrayList<HrdDTO> result = new ArrayList<>();
		JSONArray result = new JSONArray();
		HrdDTO hrd = null;
		Map<String, Object> map = null;
		for(SearchHit e : rep.searchRep(req.recommendEducationReq(address, ncsCd1, ncsCd2, ncsCd3))) {
			hrd = new HrdDTO();
			map = e.getSourceAsMap();
			hrd.setId(e.getId());
			hrd.setAddress(map.get("address").toString());
			hrd.setContents(map.get("contents").toString());
			hrd.setCourseMan(map.get("courseMan").toString());
			hrd.setEiEmplCnt3(map.get("eiEmplCnt3").toString());
			hrd.setEiEmplRate3(map.get("eiEmplRate3").toString());
			hrd.setGrade(map.get("grade").toString());
			hrd.setImgGubun(map.get("imgGubun").toString());
			hrd.setInstCd(map.get("instCd").toString());
			hrd.setNcsCd(map.get("ncsCd").toString());
			hrd.setRegCourseMan(map.get("regCourseMan").toString());
			hrd.setSubTitle(map.get("subTitle").toString());
			hrd.setSubTitleLink(map.get("subTitleLink").toString());
			hrd.setSuperViser(map.get("superViser").toString());
			hrd.setTelNo(map.get("telNo").toString());
			hrd.setTitle(map.get("title").toString());
			hrd.setTitleLink(map.get("titleLink").toString());
			hrd.setTraStartDate(map.get("traStartDate").toString());
			hrd.setTraEndDate(map.get("traEndDate").toString());
			hrd.setTrainTarget(map.get("trainTarget").toString());
			hrd.setTrainTargetCd(map.get("trainTargetCd").toString());
			result.add(hrd);
			hrd = null;
			map = null;
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray readFaceBookDAO() throws IOException {
		Map<String, Object> map = null;
		FaceBookDTO face = null;
		JSONArray result = new JSONArray();
		for(SearchHit e : rep.searchRep(req.readFaceBookReq())) {
			face = new FaceBookDTO();
			map = e.getSourceAsMap();
			face.setTitle(map.get("title").toString());
			face.setDate(map.get("date").toString());
			face.setUrl(map.get("url").toString());
			result.add(face);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray readBlogDAO() throws IOException {
		Map<String, Object> map = null;
		JSONArray result = new JSONArray();
		JSONObject object = null;
		for(SearchHit e : rep.searchRep(req.readBlogReq())) {
			object = new JSONObject();
			map = e.getSourceAsMap();
			object.put("title", map.get("titel").toString());
			object.put("endDate", map.get("endDate").toString());
			object.put("name", map.get("name").toString());
			object.put("startDate", map.get("startDate").toString());
			result.add(object);
		}
		return result;
	}
	
	public WeightDTO readWeightDAO(String id) throws IOException {
		Map<String, Object> map = rep.getUserTypeScoreRep(req.readWeightReq(id)).getSourceAsMap();
		if(map == null) {
			return null;
		}else {
			WeightDTO weight = new WeightDTO();
			weight.setId(id);
			weight.setSalLevel(Integer.parseInt(map.get("salLevel").toString()));
			weight.setWorkTime(Integer.parseInt(map.get("workTime").toString()));
			weight.setWorkInfo(Integer.parseInt(map.get("workInfo").toString()));
			weight.setDistance(Integer.parseInt(map.get("distance").toString()));
			weight.setWorkability(Integer.parseInt(map.get("workability").toString()));
			weight.setCareers(Integer.parseInt(map.get("careers").toString()));
			return weight;
		}
		
	}
	
}
