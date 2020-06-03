package job.model.elk.dao;

import java.util.ArrayList;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import job.model.elk.dto.FaceBookDTO;
import job.model.elk.dto.HrdDTO;
import job.model.elk.dto.JKDataDTO;
import job.model.elk.dto.ResumeDTO;
import job.model.elk.dto.ScoreDTO;
import job.model.elk.dto.WeightDTO;
import job.model.elk.dto.WorknetDTO;




@Component
public class ElasticSearchRequest {
	
	public BulkRequest createTestReq(ArrayList<ScoreDTO> data) {
		BulkRequest request = new BulkRequest();
		for (ScoreDTO e : data) {
			request.add(new IndexRequest("test_analisys").id(e.getId())
					.source(
					"name", e.getName(), 
					"salLevel", e.getSalLevel(), 
					"workTime", e.getWorkTime(), 
					"workInfo", e.getWorkInfo(), 
					"distance", e.getDistance(),
					"workability", e.getWorkability(),
					"careers", e.getCareers()
					));
		}
		return request;
	}
	
	public BulkRequest createCompanyNameReq(ArrayList<String> data, String index) {
		BulkRequest request = new BulkRequest();
		for (String e : data) {
			request.add(new IndexRequest(index).source("name", e));
		}
		return request;
	}
	
	public BulkRequest createFBDataReq(ArrayList<FaceBookDTO> data) {
		BulkRequest request = new BulkRequest();
		for (FaceBookDTO e : data) {
			request.add(new IndexRequest("facebook").id(e.getTitle()).source("title", e.getTitle(), "date", e.getDate(), "url", e.getUrl()));
		}
		return request;
	}
	
	public BulkRequest createCrawlingDataReq(ArrayList<JKDataDTO> data) {
		BulkRequest request = new BulkRequest();
		for (JKDataDTO e : data) {
			request.add(new IndexRequest("jk_data").id(e.getName()).source("titel", e.getTitle(), "endDate", e.getEndDate(), "name", e.getName(), "startDate", e.getStartDate()));
		}
		return request;
	}
	
	public BulkRequest createWorknetIdReq(ArrayList<WorknetDTO> id) {
		BulkRequest request = new BulkRequest();
		for (WorknetDTO e : id) {
			request.add(new IndexRequest("worknet").id(e.getWantedAuthNo()).source("salTpNm", e.getSalTpNm(), "minPay",
					e.getMinSal(), "maxPay", e.getMaxSal()));
		}
		return request;
	}

	public SearchRequest readWorknetIdSearchReq() {
		SearchRequest searchRequest = new SearchRequest("worknet");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery()).size(3000);
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}

	public UpdateRequest updateWorkNetDetailReq(WorknetDTO JobOffer) {
		UpdateRequest request = new UpdateRequest("worknet", JobOffer.getWantedAuthNo()).doc(
				"corpNm",JobOffer.getCorpNm(), 
				"jobsCd", JobOffer.getJobsCd(), 
				"relJobsNm", JobOffer.getRelJobsNm(), 
				"totPsncnt",JobOffer.getTotPsncnt(), 
				"capitalAmt", JobOffer.getCapitalAmt(), 
				"yrSalesAmt", JobOffer.getYrSalesAmt(),
				"indTpCdNm", JobOffer.getIndTpCdNm(), 
				"busiCont", JobOffer.getBusiCont(), 
				"busiSize", JobOffer.getBusiSize(), 
				"corpAddr", JobOffer.getCorpAddr(), 
				"jobsNm", JobOffer.getJobsNm(),
				"wantedTitle", JobOffer.getWantedTitle(), 
				"empTpNm", JobOffer.getEmpTpCd(), 
				"collectPsncnt", JobOffer.getCollectPsncnt(), 
				"enterTpNm", JobOffer.getEnterTpCd(), 
				"eduNm", JobOffer.getEduNm(),
				"major", JobOffer.getMajor(), 
				"certificate", JobOffer.getCertificate(), 
				"compAbl", JobOffer.getCompAbl(), 
				"pfCond", JobOffer.getPfCond(), 
				"etcPfCond", JobOffer.getEtcPfCond(),
				"workRegion", JobOffer.getWorkRegion(), 
				"retirepay", JobOffer.getRetirepay(), 
				"maxEdubgIcd", JobOffer.getMaxEdubgIcd(), 
				"minEdubgIcd", JobOffer.getMinEdubgIcd(), 
				"regionCd", JobOffer.getRegionCd(),
				"empTpCd", JobOffer.getEmpTpCd(), 
				"enterTpCd", JobOffer.getEnterTpCd(), 
				"staAreaRegionCd",JobOffer.getStaAreaRegionCd(),
				"workdayWorkhrCont",JobOffer.getWorkdayWorkhrCont()
				);

		return request;
	}

	public SearchRequest ReadWorknetRecommandReq(int gradeSal) {
		SearchRequest searchRequest = new SearchRequest("worknet");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		// searchSourceBuilder.query(QueryBuilders.rangeQuery("minPay").gte(gradeSal)).size(2000);
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.termsQuery("jobsCd", "027101", "027101"))
				.filter(QueryBuilders.rangeQuery("minPay").gte(gradeSal)));
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public BulkRequest createFComReq(ArrayList<String> names) {
		BulkRequest request = new BulkRequest();
		for (String e : names) {
			request.add(new IndexRequest("foreign_companies").source("name",e));
		}
		return request;
	}
	
	public IndexRequest creatUserReq(ResumeDTO user) {
		IndexRequest request = new IndexRequest("user").id(user.getUser_id()).source(
				"user_id", user.getUser_id(),
				"user_name", user.getUser_name(),
				"user_type", "null",
				"title", user.getTitle(),
				"profile", user.getProfile(),
				"user_prefix", user.getUser_prefix(),
				"user_age", user.getUser_age(),
				"user_hphone", user.getUser_hphone(),
				"user_email1", user.getUser_email1(),
				"user_zipcode", user.getUser_zipcode(),
				"user_addr1", user.getUser_addr1(),
				"user_addr2", user.getUser_addr2(),
				"user_jangae", user.getUser_jangae(),
				"user_army", user.getUser_army(),
				"job_code_type1", user.getJobCode_type1(),
				"job_code_type2", user.getJobCode_type2(),
				"job_code_type3", user.getJobCode_type3(),
				"job_name_type1", user.getJobName_type1(),
				"job_name_type2", user.getJobName_type2(),
				"job_name_type3", user.getJobName_type3(),
				"grade_gtype", user.getGrade_gtype(),
				"grade_money", user.getGrade_money(),
				"grade_money_type", user.getGrade_money_type(),
				"grade_lastgrade", user.getGrade_lastgrade(),
				"grade1_endYear", user.getGrade1_endYear(),
				"grade1_schoolName", user.getGrade1_schoolName(),
				"grade1_schoolEnd", user.getGrade1_schoolEnd(),
				"grade1_schoolCity", user.getGrade1_schoolCity(),
				"skill_word", user.getSkill_word(),
				"skill_ppt", user.getSkill_ppt(),
				"skill_excel", user.getSkill_excel(),
				"skill_search", user.getSkill_search(),
				"skill_list", user.getSkill_list(),
				"HopeSize", user.getHopeSize(),
				"career_1", user.getCareer_1(),
				"career_2", user.getCareer_2(),
				"career_3", user.getCareer_3(),
				"career_4", user.getCareer_4(),
				"guin_grade", user.getGuin_grade() ,
				"enter_type", user.getEnter_type()
				);
		return request;
	}
	
	public SearchRequest readUserTypeSearchReq() {
		SearchRequest searchRequest = new SearchRequest("user");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("user_type"))).size(100);
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
//	public SearchRequest readUserinfoReq(String id) {
//		SearchRequest searchRequest = new SearchRequest("user");
//		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//		searchSourceBuilder.query(QueryBuilders.termQuery("_id", id));
//		searchRequest.source(searchSourceBuilder);
//		return searchRequest;
//	}
	
	public GetRequest readUserinfoReq(String id) {
		GetRequest getRequest = new GetRequest(
		        "user", 
		        id);   
		return getRequest;
	}
	
	public UpdateRequest updateResumeReq(ResumeDTO user) {
		UpdateRequest request = new UpdateRequest(
				"user", user.getUser_id()).doc(
				"user_type", user.getUser_type(),
				"enter_type", user.getEnter_type());
		return request;
	}
	
	public SearchRequest readRecNewJobReq(ResumeDTO user) {
		SearchRequest searchRequest = new SearchRequest("worknet");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery()
				.must(QueryBuilders.rangeQuery("minPay").gte(user.getGrade_money()))
				.mustNot(QueryBuilders.matchQuery("enterTpCd", "E"))
				.mustNot(QueryBuilders.matchQuery("salTpNm", "시급"))
				.should(QueryBuilders.matchQuery("jobsCd", user.getJobCode_type1()))
				.should(QueryBuilders.matchQuery("jobsCd", user.getJobCode_type2()))
				.should(QueryBuilders.matchQuery("jobsCd", user.getJobCode_type3()))
				).size(500);
		return searchRequest;
	}
	
	public SearchRequest readRecCareerJobReq(ResumeDTO user) {
		SearchRequest searchRequest = new SearchRequest("worknet");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery()
				.must(QueryBuilders.rangeQuery("minPay").gte(user.getGrade_money()))
				.mustNot(QueryBuilders.matchQuery("enterTpCd", "N"))
				.mustNot(QueryBuilders.matchQuery("salTpNm", "시급"))
				.should(QueryBuilders.matchQuery("jobsCd", user.getJobCode_type1()))
				.should(QueryBuilders.matchQuery("jobsCd", user.getJobCode_type2()))
				.should(QueryBuilders.matchQuery("jobsCd", user.getJobCode_type3()))
				).size(500);
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public SearchRequest readCompanyNameReq(String index, String name) {
		SearchRequest searchRequest = new SearchRequest(index);
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("name", name)));
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public GetRequest readGetUserTypeScoreReq(String id) {
		GetRequest getRequest = new GetRequest(
		        "user_type_score", 
		        id);   
		return getRequest;
	}
	
	public SearchRequest readCompanyScoreReq() {
		SearchRequest searchRequest = new SearchRequest("test_analisys");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery())).size(500);
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public SearchRequest readUserReq() {
		SearchRequest searchRequest = new SearchRequest("user");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery())).size(1000);
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public IndexRequest creatUserTypeReq(ScoreDTO score) {
		IndexRequest request = new IndexRequest("user_type_score")
				.id(score.getId()).source(
						"salLevel", score.getSalLevel(),
						"workTime", score.getWorkTime(),
						"workInfo", score.getWorkInfo(),
						"distance", score.getDistance(),
						"workability", score.getWorkability(),
						"careers", score.getCareers()
						);
			
				
		return request;
	}
	
	public IndexRequest creatUserWeightReq(WeightDTO score) {
		IndexRequest request = new IndexRequest("user_weight_score")
				.id(score.getId()).source(
						"salLevel", score.getSalLevel(),
						"workTime", score.getWorkTime(),
						"workInfo", score.getWorkInfo(),
						"distance", score.getDistance(),
						"workability", score.getWorkability(),
						"careers", score.getCareers()
						);
			
				
		return request;
	}
	
	public SearchRequest readJobCodeNameReq(String jobName) {
		SearchRequest searchRequest = new SearchRequest("job_code");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("worknet_name", jobName)));
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public IndexRequest creatEucationReq(HrdDTO edu) {
		IndexRequest request = new IndexRequest("education").id(edu.getId()).source(
				"address", edu.getAddress(),
				"contents", edu.getContents(),
				"courseMan", edu.getCourseMan(),
				"eiEmplCnt3", edu.getEiEmplCnt3(),
				"eiEmplRate3", edu.getEiEmplRate3(),
				"grade", edu.getGrade(),
				"imgGubun", edu.getImgGubun(),
				"instCd", edu.getInstCd(),
				"ncsCd", edu.getNcsCd(),
				"regCourseMan", edu.getRegCourseMan(),
				"subTitle", edu.getSubTitle(),
				"subTitleLink", edu.getSubTitleLink(),
				"superViser", edu.getSuperViser(),
				"telNo", edu.getTelNo(),
				"title", edu.getTitle(),
				"titleLink", edu.getTitleLink(),
				"traStartDate", edu.getTraStartDate(),
				"traEndDate", edu.getTraEndDate(),
				"trainTarget", edu.getTrainTarget(),
				"trainTargetCd",edu.getTrainTargetCd() 
				);
		return request;
	}
	
	public BulkRequest creatEucationBulkReq(ArrayList<HrdDTO> dto) {
		BulkRequest request = new BulkRequest();
		for (HrdDTO edu : dto) {
			request.add(new IndexRequest("education").id(edu.getId()).source(
					"address", edu.getAddress(),
					"contents", edu.getContents(),
					"courseMan", edu.getCourseMan(),
					"eiEmplCnt3", edu.getEiEmplCnt3(),
					"eiEmplRate3", edu.getEiEmplRate3(),
					"grade", edu.getGrade(),
					"imgGubun", edu.getImgGubun(),
					"instCd", edu.getInstCd(),
					"ncsCd", edu.getNcsCd(),
					"regCourseMan", edu.getRegCourseMan(),
					"subTitle", edu.getSubTitle(),
					"subTitleLink", edu.getSubTitleLink(),
					"superViser", edu.getSuperViser(),
					"telNo", edu.getTelNo(),
					"title", edu.getTitle(),
					"titleLink", edu.getTitleLink(),
					"traStartDate", edu.getTraStartDate(),
					"traEndDate", edu.getTraEndDate(),
					"trainTarget", edu.getTrainTarget(),
					"trainTargetCd",edu.getTrainTargetCd()
					));
		}
		return request;
	}
	
	public SearchRequest readNcsCodeReq(String worknetCode) {
		SearchRequest searchRequest = new SearchRequest("job_code");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("worknet_code", worknetCode))).size(1);
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public SearchRequest recommendEducationReq(String address, String ncsCd1, String ncsCd2, String ncsCd3) {
		SearchRequest searchRequest = new SearchRequest("education");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.minScore(1).query(
				QueryBuilders.boolQuery().must(
						QueryBuilders.matchQuery("address", address)).
				should(QueryBuilders.termQuery("ncsCd", ncsCd1)).
				should(QueryBuilders.termQuery("ncsCd", ncsCd2)).
				should(QueryBuilders.termQuery("ncsCd", ncsCd3))
				).size(100);
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public SearchRequest readFaceBookReq() {
		SearchRequest searchRequest = new SearchRequest("facebook");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(200).query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public SearchRequest readBlogReq() {
		SearchRequest searchRequest = new SearchRequest("jk_data");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(200).query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}
	
	public GetRequest readWeightReq(String id) {
		GetRequest getRequest = new GetRequest(
		        "user_weight_score", 
		        id);   
		return getRequest;
	}
	
}
