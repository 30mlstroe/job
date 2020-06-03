package job.model.elk.dao;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ElasticSearchConfig {
	
	public RestHighLevelClient connectES() {
		System.out.println("ElasticSearch Connect OK");
		return new RestHighLevelClient(RestClient.builder(new HttpHost("52.79.239.40", 9200, "http")));
	}
	
	
	public void closeESConnection() throws IOException{
		connectES().close();
	}
}
