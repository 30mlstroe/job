package job.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import job.API.OpenAPI;
import job.API.XmlPasing;
import job.model.elk.dao.ElasticSearchDAO;
import job.model.elk.dto.ResumeDTO;

@Service
public class JobRecommendService {

	@Autowired
	OpenAPI api;

	@Autowired
	XmlPasing xml;

	@Autowired
	ElasticSearchDAO elk;

	
	public ArrayList<String> getCompanyName(ResumeDTO user) throws ParserConfigurationException, SAXException, IOException, ParseException {
		ArrayList<String> companyNames = new ArrayList<>();
		ArrayList<Matcher> matchers = new ArrayList<>();
		Pattern p = Pattern.compile("(.*?),(.*?),(.*?),(.*?),(.*?)");
		//20151201,20181130,알티캐스트,QA부서,연구원
		matchers.add(p.matcher(user.getCareer_1().toString()));
		matchers.add(p.matcher(user.getCareer_2().toString()));
		matchers.add(p.matcher(user.getCareer_3().toString()));
		matchers.add(p.matcher(user.getCareer_4().toString()));
		for(int i = 0; i<matchers.size(); i++) {
			if(matchers.get(i).find()){
				companyNames.add(matchers.get(i).group(3));
			}
		}
		return companyNames;
	}
	
	
}
