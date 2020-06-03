package job.scraping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import job.model.elk.dto.FaceBookDTO;

@Component
public class Scraping {

	@Autowired
	ScrapingPatten sp;

	private final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private final String WEB_DRIVER_PATH = ".\\driver\\chromedriver.exe";
	private WebDriver driver;
	private String baseUrl = "https://blog.naver.com";

	public void base() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1200x600");
	}

	public ArrayList<String> getBlogPageUrl(Integer num) {
		ArrayList<String> urls = new ArrayList<>();
		try {
			driver.get("https://blog.naver.com/PostList.nhn?from=postList&blogId=jobkorea1&categoryNo=106&currentPage="
					+ num.toString());
			Document doc = Jsoup.parse(driver.getPageSource());
			for (Element a : doc.select("#PostThumbnailAlbumViewArea > ul > li > a")) {
				urls.add(a.attr("href"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return urls;
	}

	public String getBlogTitle(String url) {
		String title = null;
		try {
			driver.get(baseUrl + url);
			Document doc = Jsoup.parse(driver.getPageSource());
			Elements a = doc.select("div.se-module > p.se-text-paragraph > span.se-fs-fs32 ");
			title = a.text();

		} catch (Exception e) {
			System.out.println(e);
		}
		return title;
	}

	public String getBlogName(String url) {
		String result = null;
		try {
			driver.get(baseUrl + url);
			Document doc = Jsoup.parse(driver.getPageSource());
			Element a = doc.select("span.ell").get(0);
			result = a.text().replace("#", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public String getBlogStartDate(String url) {
		String result = null;
		try {
			driver.get(baseUrl + url);
			Document doc = Jsoup.parse(driver.getPageSource());
			Element a = doc.select("div.blog2_container > span.se_publishDate").get(0);
			result = a.text();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public void closeDriver() {
		driver.close();
		driver = null;
	}
	
	public ArrayList<FaceBookDTO> faceBookScraping() {
		ArrayList<FaceBookDTO> fb = new ArrayList<>();
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("https://www.facebook.com/japan.recruiting/");
			js.executeScript("window.scrollBy(0,20000)");
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("#expanding_cta_close_button")).click();// 팝업 닫기

			for (int i = 0; i < 22;) {
				js.executeScript("window.scrollBy(0,20000)");
				Thread.sleep(5000);
				i++;
			}
			js.executeScript("window.scrollBy(0,-200000)");
			for (WebElement e : driver.findElements(By.cssSelector(
					"div._5pcr > div > div > div > div.text_exposed_root > span > span > a.see_more_link > span.see_more_link_inner"))) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
				Thread.sleep(1000);
			}
			Document doc = Jsoup.parse(driver.getPageSource());
			String title = null;
			String date = null;
			String url = null;
			for (Element e : doc.select("div._4-u2 > div._427x > div._4-u2 > div._3ccb > div._5pcr > div._1dwg")) {
				title = sp.getFBTitle(e.text());
				date = sp.getFBDate(e.select("span.fsm > a > abbr > span.timestampContent").text());
				url = sp.getFBUrl(e.text());
				if(!title.equals("null") && !date.equals("null") &&  !url.equals("null") ) {
					fb.add(new FaceBookDTO(title, date, url));
				}
				title = null;
				date = null;
				url = null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return fb;
	}
	
}
