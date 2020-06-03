package job.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import job.model.elk.dto.HrdDTO;
import job.model.elk.dto.WorknetDTO;

@Component
public class XmlPasing {
	@Autowired
	OpenAPI api;

	private static String getTagValue(String tag, Element eElement) {
		try {
			NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
			Node nValue = (Node) nlList.item(0);
			if (nValue == null)
				return "null";
			return nValue.getNodeValue();
		} catch (Exception e) {
			// TODO: handle exception
			return "null";
		}

	}

	public String pasingJobTotal(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource t_is = new InputSource();
		t_is.setCharacterStream(new StringReader(xml));
		Document doc = dBuilder.parse(t_is);
		doc.getDocumentElement().normalize();// 문서 구조 안정화
		NodeList nList = doc.getElementsByTagName("wantedRoot");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				return new String(getTagValue("total", eElement));

			}
		}
		return null;

	}

	public ArrayList<WorknetDTO> pasingJobList(String xml)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource t_is = new InputSource();
		t_is.setCharacterStream(new StringReader(xml));
		Document doc = dBuilder.parse(t_is);
		doc.getDocumentElement().normalize();// 문서 구조 안정화
		NodeList nList = doc.getElementsByTagName("wanted");
		ArrayList<WorknetDTO> list = new ArrayList<>();
		String salTpNm;
		int minSal;
		int maxSal;
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				salTpNm = getTagValue("salTpNm", eElement);
				minSal = Integer.parseInt(getTagValue("minSal", eElement));
				maxSal = Integer.parseInt(getTagValue("maxSal", eElement));
				if (salTpNm.equals("월급")) {
					minSal = minSal * 12;
					maxSal = maxSal * 12;
					salTpNm = "연봉";
				}

				list.add(new WorknetDTO(getTagValue("wantedAuthNo", eElement), salTpNm, minSal, maxSal));
			}
		}
		return list;

	}

	public WorknetDTO pasingJobDetail(String xml) throws ParserConfigurationException, SAXException, IOException {
		WorknetDTO work = new WorknetDTO();
		if(xml == null) {
			return null;
		}
		String match = "[^\\u0009\\u000A\\u000D\\u0020-\\uD7FF\\uE000-\\uFFFD\\u10000-\\u10FFF]+";
		xml = xml.replaceAll(match, "");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource t_is = new InputSource();
		t_is.setCharacterStream(new StringReader(xml));
		Document doc = dBuilder.parse(t_is);
		doc.getDocumentElement().normalize();// 문서 구조 안정화
		NodeList nList = doc.getElementsByTagName("wantedDtl");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				work.setJobsCd(getTagValue("jobsCd", eElement));
				work.setWantedAuthNo(getTagValue("wantedAuthNo", eElement));
				work.setJobsCd(getTagValue("jobsCd", eElement));
				work.setRelJobsNm(getTagValue("relJobsNm", eElement));
				work.setCorpNm(getTagValue("corpNm", eElement));
				work.setTotPsncnt(getTagValue("totPsncnt", eElement));
				work.setCapitalAmt(getTagValue("capitalAmt", eElement));
				work.setYrSalesAmt(getTagValue("yrSalesAmt", eElement));
				work.setIndTpCdNm(getTagValue("indTpCdNm", eElement));
				work.setBusiCont(getTagValue("busiCont", eElement));
				work.setBusiSize(getTagValue("busiSize", eElement));
				work.setCorpAddr(getTagValue("corpAddr", eElement));
				work.setJobsNm(getTagValue("jobsNm", eElement));
				work.setWantedTitle(getTagValue("wantedTitle", eElement));
				work.setEmpTpNm(getTagValue("empTpNm", eElement));
				work.setCollectPsncnt(getTagValue("collectPsncnt", eElement));
				work.setEnterTpNm(getTagValue("enterTpNm", eElement));
				work.setEduNm(getTagValue("eduNm", eElement));
				work.setMajor(getTagValue("major", eElement));
				work.setCertificate(getTagValue("certificate", eElement));
				work.setCompAbl(getTagValue("compAbl", eElement));
				work.setPfCond(getTagValue("pfCond", eElement));
				work.setEtcPfCond(getTagValue("etcPfCond", eElement));
				work.setWorkRegion(getTagValue("workRegion", eElement));
				work.setRetirepay(getTagValue("retirepay", eElement));
				work.setMaxEdubgIcd(getTagValue("maxEdubgIcd", eElement));
				work.setMinEdubgIcd(getTagValue("minEdubgIcd", eElement));
				work.setRegionCd(getTagValue("regionCd", eElement));
				work.setEmpTpCd(getTagValue("empTpCd", eElement));
				work.setEnterTpCd(getTagValue("enterTpCd", eElement));
				work.setStaAreaRegionCd(getTagValue("staAreaRegionCd", eElement));
				work.setWorkdayWorkhrCont(getTagValue("workdayWorkhrCont", eElement));
			}
		}
		return work;
	}
	
	public String pasingEmployeesSeq(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource t_is = new InputSource();
		t_is.setCharacterStream(new StringReader(xml));
		Document doc = dBuilder.parse(t_is);
		doc.getDocumentElement().normalize();// 문서 구조 안정화
		NodeList nList = doc.getElementsByTagName("items");
		String seq = "";
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				seq = (getTagValue("seq", eElement));
				break;
			}
		}
		return seq;
	}
	
	public Integer pasingEmployees(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource t_is = new InputSource();
		t_is.setCharacterStream(new StringReader(xml));
		Document doc = dBuilder.parse(t_is);
		doc.getDocumentElement().normalize();// 문서 구조 안정화
		NodeList nList = doc.getElementsByTagName("item");
		String EmployeesOfNum = "";
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				EmployeesOfNum = (getTagValue("jnngpCnt", eElement));
			}
		}
		if(EmployeesOfNum.equals("")) {
			return 0;
		}
		return Integer.parseInt(EmployeesOfNum);
	}
	
	
	public String pasingEducationTotal(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource t_is = new InputSource();
		t_is.setCharacterStream(new StringReader(xml));
		Document doc = dBuilder.parse(t_is);
		doc.getDocumentElement().normalize();// 문서 구조 안정화
		NodeList nList = doc.getElementsByTagName("HRDNet");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				return new String(getTagValue("scn_cnt", eElement));

			}
		}
		return null;

	}
	
	public ArrayList<HrdDTO> pasingEducationList(String xml)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource t_is = new InputSource();
		t_is.setCharacterStream(new StringReader(xml));
		Document doc = dBuilder.parse(t_is);
		doc.getDocumentElement().normalize();// 문서 구조 안정화
		NodeList nList = doc.getElementsByTagName("scn_list");
		ArrayList<HrdDTO> list = new ArrayList<>();
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				HrdDTO dto = new HrdDTO();
				dto.setId(getTagValue("trprId", eElement).toString());
				dto.setAddress(getTagValue("address", eElement).toString());
				dto.setContents(getTagValue("contents", eElement).toString());
				dto.setCourseMan(getTagValue("courseMan", eElement).toString());
				dto.setEiEmplCnt3(getTagValue("eiEmplCnt3", eElement).toString());
				dto.setEiEmplRate3(getTagValue("eiEmplRate3", eElement).toString());
				dto.setEiEmplRate6(getTagValue("eiEmplRate6", eElement).toString());
				dto.setGrade(getTagValue("grade", eElement).toString());
				dto.setImgGubun(getTagValue("imgGubun", eElement).toString());
				dto.setInstCd(getTagValue("instCd", eElement).toString());
				dto.setNcsCd(getTagValue("ncsCd", eElement).toString());
				dto.setRegCourseMan(getTagValue("regCourseMan", eElement).toString());
				dto.setSubTitle(getTagValue("subTitle", eElement).toString());
				dto.setSubTitleLink(getTagValue("subTitleLink", eElement).toString());
				dto.setSuperViser(getTagValue("superViser", eElement).toString());
				dto.setTelNo(getTagValue("telNo", eElement).toString());
				dto.setTitle(getTagValue("title", eElement).toString());
				dto.setTitleLink(getTagValue("titleLink", eElement).toString());
				dto.setTraStartDate(getTagValue("traStartDate", eElement).toString());
				dto.setTraEndDate(getTagValue("traEndDate", eElement).toString());
				dto.setTrainTarget(getTagValue("trainTarget", eElement).toString());
				dto.setTrainTargetCd(getTagValue("trainTargetCd", eElement).toString());
				list.add(dto);
			}
		}
		return list;

	}
}
