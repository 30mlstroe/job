package job.model.elk.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Component;

import job.model.elk.dto.WorknetDTO;

@Component
public class ElasticSearchResponse {
	private RestHighLevelClient client = new RestHighLevelClient(
			RestClient.builder(new HttpHost("52.79.239.40", 9200, "http"), new HttpHost("52.79.239.40", 9201, "http")));
	
	

	public Result createBulkRep(BulkRequest request) {
		DocWriteResponse itemResponse = null;
		try {
			BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
			// 실패만 저장하여 리턴
			for (BulkItemResponse bulkItemResponse : bulkResponse) {
				itemResponse = bulkItemResponse.getResponse();
				
			}
		} catch (ElasticsearchException | IOException e) {
			e.printStackTrace();
		}
		return itemResponse.getResult();

	}

	public ArrayList<String> worknetIdSearchRep(SearchRequest searchRequest) {
		ArrayList<String> idList = new ArrayList<>();
		try {
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			SearchHits hits = searchResponse.getHits();
			for (SearchHit e : hits) {
				idList.add(e.getId());
			}
		} catch (ElasticsearchException | IOException e1) {
			e1.printStackTrace();
		}
		return idList;
	}

	public Result updatePostRep(UpdateRequest request) {
		UpdateResponse updateResponse = null;
		try {
			updateResponse = client.update(request, RequestOptions.DEFAULT);

		} catch (Exception e) {
			System.out.println(e);
		}
		return updateResponse.getResult();
	}

	public SearchHits searchRep(SearchRequest request) {
		SearchResponse Response = null;
		try {
			Response = client.search(request, RequestOptions.DEFAULT);
		} catch (Exception e) {
			System.out.println(e);
		}
		return Response.getHits();
	}

	public Result createUserRep(IndexRequest request) {
		IndexResponse indexResponse = null;
		try {
			indexResponse = client.index(request, RequestOptions.DEFAULT);
		} catch (ElasticsearchException | IOException e) {
			System.out.println(e);
		}
		return indexResponse.getResult();
	}

	public ArrayList<WorknetDTO> worknetCorpNmAllRep(SearchRequest searchRequest) {
		ArrayList<WorknetDTO> data = new ArrayList<>();
		try {
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			SearchHits hits = searchResponse.getHits();
			for (SearchHit e : hits) {
				Map<String, Object> sourceAsMap = e.getSourceAsMap();
				if((String) sourceAsMap.get("corpNm") != null) {
					data.add(new WorknetDTO(
							e.getId(), 
							(String) sourceAsMap.get("corpNm"),
							(Integer) sourceAsMap.get("minPay"),
							(String) sourceAsMap.get("empTpCd"),
							(String) sourceAsMap.get("corpAddr")
							));
				}
				
			}
		} catch (ElasticsearchException | IOException e1) {
			e1.printStackTrace();
		}
		return data;
	}

	public GetResponse getUserTypeScoreRep(GetRequest request) {
		
		try {
			GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
			return getResponse;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
