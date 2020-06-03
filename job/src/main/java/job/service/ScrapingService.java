package job.service;


import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import job.model.elk.dao.ElasticSearchDAO;
import job.model.elk.dto.JKDataDTO;
import job.scraping.Scraping;
import job.scraping.ScrapingPatten;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.json.simple.JSONObject;


@Service
public class ScrapingService {
	
	@Autowired
	Scraping sc;
	
	@Autowired
	ElasticSearchDAO elk;
	
	@Autowired
	ScrapingPatten sp;
	
	public Result blogScrapingService() throws Exception {
		ArrayList<JKDataDTO> data = new ArrayList<>();
		String title;
		String name;
		sc.base();
		for(Integer i=1; i<=10; i++) {
			for(String e : sc.getBlogPageUrl(i)) {
				name = sc.getBlogName(e);
				title = sc.getBlogTitle(e);
				if(!name.equals("null") && !title.equals("null")) {
					data.add(new JKDataDTO(title, sp.getBlogDate(sc.getBlogStartDate(e)), sp.getPattenDate(title), name));
				}
			}
			Thread.sleep(5000);
		}
		Result result = elk.JKDataBulkDAO(data);
		sc.closeDriver();
		return result;
	}
	
	public Result faceBookScrapingService() throws IOException {
		sc.base();
		Result result = elk.FBBulkDAO(sc.faceBookScraping());
		sc.closeDriver();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject SNSScrapingService() throws Exception {
		JSONObject object = new JSONObject();
		sc.base();
		object.put("FaceBook", elk.FBBulkDAO(sc.faceBookScraping()));
		sc.closeDriver();
		
		ArrayList<JKDataDTO> data = new ArrayList<>();
		String title;
		String name;
		sc.base();
		for(Integer i=1; i<=10; i++) {
			for(String e : sc.getBlogPageUrl(i)) {
				title = sc.getBlogTitle(e);
				name = sc.getBlogName(e);
				data.add(new JKDataDTO(title, sp.getBlogDate(sc.getBlogStartDate(e)), sp.getPattenDate(title), name));
			}
			Thread.sleep(5000);
		}
		object.put("JKDATA", elk.JKDataBulkDAO(data));
		
		
		return object;
	}
}
