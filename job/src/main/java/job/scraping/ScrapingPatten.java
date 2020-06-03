package job.scraping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class ScrapingPatten {

	public String getPattenDate(String title) {
		Pattern p = Pattern.compile("\\~(.*?)/(.*?)\\)");
		Matcher m = p.matcher(title);
		String month = null;
		String day = null;
		if (m.find()) {
			month = m.group(1);
			day = m.group(2);

			if (month.length() == 1) {
				month = "0" + month;
			}
			if (day.length() == 1) {
				day = "0" + day;
			}
			return month + day;
		}
		return "채용시마감";

	}

	public String getFBTitle(String title) throws Exception {
		
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(title);
		if (m.find()) {
			return m.group();
		} else {
			p = Pattern.compile("\\<(.*?)\\>");
			m = p.matcher(title);
			if (m.find()) {
				return m.group();
			}
			return "null";
		}
	}

	public String getFBDate(String date) throws Exception {
		Pattern p = Pattern.compile("(.*?)월 (.*?)일");
		Matcher m = p.matcher(date);
		if(m.find()) {
			return m.group();
		}else {
			p = Pattern.compile("(.*?)시간");
			m = p.matcher(date);
			if(m.find()) {
				return "오늘";
			}
			return "null";
		}
		
	}

	public String getFBUrl(String data) throws Exception {
		Pattern p = Pattern.compile("https(.*?) ");
		Matcher m = p.matcher(data);
		if (m.find()) {
			return m.group(0);
		}else{
			p = Pattern.compile("http(.*?) ");
			m = p.matcher(data);
			if(m.find()) {
				return m.group(0);
			}else {
				return "null";
			}
		}
	}

	public String getBlogDate(String date) throws Exception {
		Pattern p = Pattern.compile("2020. (.*?). (.*?). ");
		Matcher m = p.matcher(date);

		if (m.find()) {
			String month = m.group(1);
			String day = m.group(2);

			if (month.length() == 1) {
				month = "0" + month;
			}
			if (day.length() == 1) {
				day = "0" + day;
			}
			return month + day;
		} else {
			SimpleDateFormat format1 = new SimpleDateFormat("MMdd");
			Date time = new Date();
			return format1.format(time);
		}

	}
	
	public String getCity(String date) throws Exception {
		Pattern p = Pattern.compile("(.*?) (.*?)도 (.*?) ");
		Matcher m = p.matcher(date);
		if (m.find()) {
			return m.group(3).replace(" ", "");
		}else {
			p = Pattern.compile("(.*?) (.*?) ");
			m = p.matcher(date);
			if(m.find()) {
				return m.group(2).replace(" ", "");
			}
		}

		return "서울시";
	}
	
	public String getUserCity(String data) throws Exception {
		Pattern p = Pattern.compile("(.*?)도 (.*?) (.*?) ");
		Matcher m = p.matcher(data);
		if (m.find()) {
			return m.group(2).replace(" ", "");
		}else {
			p = Pattern.compile("(.*?) (.*?) ");
			m = p.matcher(data);
			if(m.find()) {
				return m.group(1).replace(" ", "");
			}
		}

		return "서울시";
	}
	
	public String getUserEuduCity(String addr) throws Exception {
		Pattern p = Pattern.compile("(.*?)시 ");
		Matcher m = p.matcher(addr);
		
		if (m.find()) {
			return m.group(0).substring(0, 2);
		}
		p = Pattern.compile(" (.*?)시 ");
		m = p.matcher(addr);
		if(m.find()){
			return m.group(0).substring(0, 2);
		}
		else{
			return "서울";
		}
	}
	
}
