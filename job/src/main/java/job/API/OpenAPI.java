package job.API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.springframework.stereotype.Component;

@Component
public class OpenAPI {
	private static String url = "http://openapi.work.go.kr/opi/opi/opia/wantedApi.do";

	public String getJobTotal(String occupation) {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);

		try {
			method.addParameter("returnType", "xml");
			method.addParameter("startPage", "1");
			method.addParameter("display", "1");
			method.addParameter("callTp", "L");
			method.addParameter("occupation", occupation);
			method.addParameter("authKey", "WNK7V684P9P8ESN8EPOEV2VR1HK");
			method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

			if (client.executeMethod(method) != HttpStatus.SC_OK)
				System.out.println(HttpStatus.SC_OK);
			return new String(method.getResponseBody(), "UTF-8");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (method != null)
				method.releaseConnection();
		}
		return null;
	}

	public String getJobList(Integer startPage, String occupation) {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);

		try {
			method.addParameter("returnType", "xml");
			method.addParameter("startPage", startPage.toString());
			method.addParameter("display", "100");
			method.addParameter("callTp", "L");
			method.addParameter("occupation", occupation);
			method.addParameter("authKey", "WNK7V684P9P8ESN8EPOEV2VR1HK");
			method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			if (client.executeMethod(method) != HttpStatus.SC_OK)
				System.out.println(HttpStatus.SC_OK);
			return new String(method.getResponseBody(), "UTF-8");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (method != null)
				method.releaseConnection();
		}
		return null;
	}

	public String getJobDetail(String wantedAuthNo) {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);

		// 필수입력항목 및 검색조건 setting
		method.addParameter("authKey", "WNK7V684P9P8ESN8EPOEV2VR1HK");
		method.addParameter("wantedAuthNo", wantedAuthNo);
		method.addParameter("callTp", "D");
		method.addParameter("returnType", "xml");
		method.addParameter("infoSvc", "VALIDATION");
		method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		try {
			if (client.executeMethod(method) != HttpStatus.SC_OK) {
				System.out.println("잘못된 서치");
			} else {
				return new String(method.getResponseBody(), "UTF-8");

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (method != null)
				method.releaseConnection();
		}
		return null;
	}

	public String educationListAPI(Integer num) {
		try {
			URL url = new URL("http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			out.write(
					"returnType=XML&authKey=3rnuiY0ttfUwZx9hECPevf8zdk4rB02k&outType=1&srchKeco1=20&srchKeco2=2001&sort=ASC&sortCol=TR_STT_DT&srchTraStDt=20200522&srchTraEndDt=20210522&pageSize=100"
							.getBytes());
			out.write(("&pageNum=" + num.toString()).getBytes());
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "EUC-KR"));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "EUC-KR"));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			return response.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
