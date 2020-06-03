package job.recommend.analysis;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import job.model.elk.dao.ElasticSearchDAO;

@Component
public class Recommend {
	
	@Autowired
	ElasticSearchDAO elk;
	
	public double getSalLevle(double sal) {
		double avr = 47008620;
		return sal/avr;
	}
	
	public double setWorkTime(String name) throws IOException {
		double workTime = 0;
		String[] index = {"first_work_time", "second_work_time"};
		for(String e : index) {
			workTime = elk.findCompanyNameDAO(e, name) + workTime;
		}
		return workTime;
	}
	
	public double setWorkInfo(String name) throws IOException {
		double workInfor = 0;
		String[] index = {"first_work_info", "second_work_info"};
		for(String e : index) {
			workInfor = elk.findCompanyNameDAO(e, name) + workInfor;
		}
		return workInfor;
	}
	
	public String getWorkbility(String code) {
		String result = "비정규직";
		if(code.equals("10") || code.equals("11")) {
			result = "정규직";
		}
		return result;
	}
	
	public double setCareers(String name) throws IOException {
		if( elk.findCompanyNameDAO("foreign_companies", name) > 0) {
			return 0.25;
		}
		return elk.findCompanyNameDAO("foreign_companies", name);
	}
	
}
