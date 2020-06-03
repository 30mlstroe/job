package job.model.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrdDTO {
	
	private String id;
	private String address;
	private String contents; 		//컨텐츠
	private String courseMan;		//수강비
	private String eiEmplCnt3;		//고용보험3개월 취업인원 수
	private String eiEmplRate3;		//	고용보험3개월 취업률
	private String eiEmplRate6;		//	고용보험3개월 취업률
	private String grade;
	private String imgGubun;		//	제목 아이콘 구분
	private String instCd;			//훈련기관 코드
	private String ncsCd;			//NCS 코드
	private String regCourseMan;	//	실제 훈련비
	private String subTitle;		//수강신청 인원
	private String subTitleLink;	//	부 제목
	private String superViser;		//부 제목 링크
	private String telNo;			//주관부처
	private String title;
	private String titleLink;		//링크
	private String traStartDate;	//시작 날짜
	private String traEndDate;		//끝 날짜
	private String trainTarget;		//
	private String trainTargetCd;	//
	

}
