package job.model.elk.dao;

import java.io.IOException;
import java.util.Map;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import job.model.joinus.dto.JoinUsDTO;
@Component
public class ESResponse {
	@Autowired
	ElasticSearchConfig esConfig;
	
	  public Boolean checkAlreadyExistedUserByDocIdRes(GetRequest request) {
	      boolean result = false;
	      RestHighLevelClient client = esConfig.connectES();
	      try {
	         result = client.exists(request, RequestOptions.DEFAULT);
	      }catch (Exception e) {
	         System.out.println(e);
	      }
	      return result;
	   }
	
	public String registSharpleRes(IndexRequest request) {
		String result = "Fail";
		RestHighLevelClient client = esConfig.connectES();
		try{
			IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
			if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
			    result = "Succeeded";
			    client.close();
			} else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
			    result = "Updated";
			    client.close();
			}
		} catch (ElasticsearchException | IOException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	public JoinUsDTO loginSharpleRes(SearchRequest request) {
		JoinUsDTO userInfo = new JoinUsDTO();
		RestHighLevelClient client = esConfig.connectES();
		try{
			SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);
			SearchHits hits = searchResponse.getHits();
			SearchHit[] searchHits = hits.getHits();
			Map<String, Object> sourceAsMap;
			for (SearchHit hit : searchHits) {
				sourceAsMap = hit.getSourceAsMap();
				userInfo.setUser_id((String) sourceAsMap.get("user_id"));
				userInfo.setUser_email((String) sourceAsMap.get("user_email"));
				userInfo.setUser_name((String) sourceAsMap.get("user_name"));
				userInfo.setUser_phone((String) sourceAsMap.get("user_phone"));
				userInfo.setUser_pw((String) sourceAsMap.get("user_password"));
			}
			client.close();
		} catch (ElasticsearchException | IOException e) {
			System.out.println(e);
		}
		return userInfo;
	}
	
	public JoinUsDTO adminLoginRes(SearchRequest request) {
		JoinUsDTO userInfo = new JoinUsDTO();
		RestHighLevelClient client = esConfig.connectES();
		try{
			SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);
			SearchHits hits = searchResponse.getHits();
			SearchHit[] searchHits = hits.getHits();
			Map<String, Object> sourceAsMap;
			for (SearchHit hit : searchHits) {
				sourceAsMap = hit.getSourceAsMap();
				userInfo.setUser_id((String) sourceAsMap.get("user_id"));
				userInfo.setUser_email((String) sourceAsMap.get("user_email"));
				userInfo.setUser_name((String) sourceAsMap.get("user_name"));
				userInfo.setUser_phone((String) sourceAsMap.get("user_phone"));
				userInfo.setUser_pw((String) sourceAsMap.get("user_pw"));
			}
			client.close();
		} catch (ElasticsearchException | IOException e) {
			System.out.println(e);
		}
		return userInfo;
	}
	
	public JoinUsDTO myPageSharpleRes(SearchRequest request) {
		JoinUsDTO myPage = new JoinUsDTO();
		RestHighLevelClient client = esConfig.connectES();
		try{
			SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);
			SearchHits hits = searchResponse.getHits();
			SearchHit[] searchHits = hits.getHits();
			Map<String, Object> sourceAsMap;
			for (SearchHit hit : searchHits) {
				sourceAsMap = hit.getSourceAsMap();
				myPage.setUser_email(((String) sourceAsMap.get("user_email")));
				myPage.setUser_name(((String) sourceAsMap.get("user_name")));
				myPage.setUser_pw(((String) sourceAsMap.get("user_password")));
			}
			client.close();
		} catch (ElasticsearchException | IOException e) {
			System.out.println(e);
		}
		return myPage;
	}
	
	public String updateSharpleRes(UpdateRequest request) {
		String result = "Update Fail";
		RestHighLevelClient client = esConfig.connectES();
		try{
			UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
			if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED) {
			    result = "success";
			    client.close();
			} else if (updateResponse.getResult() == DocWriteResponse.Result.NOOP) {
			    result = "NOOP";
			    client.close();
			}
			
		} catch (ElasticsearchException | IOException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public String searchDocIdSharpleByUserIDRes(SearchRequest request) {
		String docId = "";
		RestHighLevelClient client = esConfig.connectES();
		try{
			SearchResponse response = client.search(request, RequestOptions.DEFAULT);
			SearchHits hits = response.getHits();
			SearchHit[] searchHits = hits.getHits();
			for (SearchHit hit : searchHits) {
				docId = hit.getId();
			}
			client.close();

		} catch (ElasticsearchException | IOException e) {
			System.out.println(e);
		}
		return docId;
	}
}
