package job.model.elk.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import job.model.joinus.dto.JoinUsDTO;

@Component
public class ESRequest {

	public IndexRequest registSharpleReq(JoinUsDTO newUser)
			throws IOException, NoSuchAlgorithmException, GeneralSecurityException {
		IndexRequest request = new IndexRequest("sharple_users").id(newUser.getUser_id());
		Map<String, String> jsonMap = new HashMap<>();

		jsonMap.put("user_id", newUser.getUser_id());
		jsonMap.put("user_name", newUser.getUser_name());
		jsonMap.put("user_email", newUser.getUser_email());
		jsonMap.put("user_password", newUser.getUser_pw());
		jsonMap.put("user_phone", newUser.getUser_phone());
		request.source(jsonMap);
		return request;

	}

	// 회원가입 요청 시 이미 등록된 사용자인지 docId로 검증하는 메소드
	public GetRequest checkAlreadyExistedUserByDocIdReq(String docId) throws IOException {
		GetRequest getRequest = new GetRequest("sharple_users", docId);
		getRequest.fetchSourceContext(new FetchSourceContext(false));
		getRequest.storedFields("_none_");
		return getRequest;
	}

	// 로그인 & 마이페이지
	public SearchRequest loginSharpleReq(String userId) throws IOException {
		SearchRequest searchRequest = new SearchRequest("sharple_users");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.termQuery("user_id", userId));
		searchRequest.source(searchSourceBuilder);
		return searchRequest;
	}

	public SearchRequest adminLoginReq(String user_id) throws IOException {
		SearchRequest searchRequest = new SearchRequest("admin_users");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("user_id", user_id)));
		return searchRequest;
	}

	// Override가 필요할 수도 있음.
	@Autowired
	protected ESResponse elaticSearchResponse;

	public UpdateRequest updateSharpleReq(JoinUsDTO userInfo) throws IOException {
		Map<String, Object> updateUserInfo = new HashMap<>();
		updateUserInfo.put("userid", userInfo.getUser_id());
		updateUserInfo.put("user_phone", userInfo.getUser_phone());
		updateUserInfo.put("user_name", userInfo.getUser_name());
		updateUserInfo.put("user_email", userInfo.getUser_email());
		updateUserInfo.put("user_password", userInfo.getUser_pw());

		SearchRequest getIdRequest = searchDocIdSharpleByUserIDReq(userInfo.getUser_id());
		String docId = elaticSearchResponse.searchDocIdSharpleByUserIDRes(getIdRequest);
		UpdateRequest request = new UpdateRequest("sharple_users", docId).doc(updateUserInfo);

		return request;
	}

	// 회원가입 요청 시 이미 등록된 사용자인지 docId로 검증하는 메소드
	public boolean checkAlreadyExistedUserByDocId(String docId) throws IOException {
		RestHighLevelClient client = new RestHighLevelClient(RestClient
				.builder(new HttpHost("3.34.47.148", 9200, "http"), new HttpHost("3.34.47.148", 9201, "http")));
		GetRequest getRequest = new GetRequest("sharple_users", docId);
		getRequest.fetchSourceContext(new FetchSourceContext(false));
		getRequest.storedFields("_none_");

		return client.exists(getRequest, RequestOptions.DEFAULT);
	}

	// 식별자 역할을 하는 doc id를 찾아오는 함수 (update에 docId를 구하기 위해 필요)
	public SearchRequest searchDocIdSharpleByUserIDReq(String user_id) throws IOException {
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		sourceBuilder.query(QueryBuilders.termQuery("user_id", user_id));

		SearchRequest searchRequest = new SearchRequest("sharple_users");
		searchRequest.source(sourceBuilder);
		return searchRequest;
	}
}
