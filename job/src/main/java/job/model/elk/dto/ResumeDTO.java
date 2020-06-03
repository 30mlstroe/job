package job.model.elk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO {
	
	private String user_id;
	private String user_name;
	private String user_type;		//대기업/중소기업
	private String title;		
	private String profile;
	private String user_prefix;		//성별
	private String user_age;
	private String user_hphone;
	private String user_email1;		//이메일
	private String user_zipcode;	//집코드
	private String user_addr1;		//주소
	private String user_addr2;		//상세주소
	private String user_jangae;		//결혼여부
	private String user_army;		//군대
	private String jobCode_type1;		//희망 직종1
	private String jobCode_type2;		//희망 직종2
	private String jobCode_type3;		//희망 직종3
	private String jobName_type1;		
	private String jobName_type2;		
	private String jobName_type3;		
	//private String keyword;
	private String grade_gtype;		//희망 고용형태
	private String grade_money;		//희망 연봉
	private String grade_money_type;//연봉
	private String grade_lastgrade; //
	private String grade1_endYear;
	private String grade1_schoolName;
	private String grade1_schoolEnd;
	private String grade1_schoolCity;
	private String skill_word; //상중하
	private String skill_ppt;	//상중하
	private String skill_excel;	//상중하
	private String skill_search;	//상중하
	private String skill_list;
	private String HopeSize;	//희망 회사 규모
	private String career_1;	//경력
	private String career_2;
	private String career_3;
	private String career_4;
	private String guin_grade;	//희망 직급
	private String enter_type;	//희망 직급
	
	public ResumeDTO(String user_id) {
		this.user_id = user_id;
	}
	
	public ResumeDTO(String user_id, String career_1, String career_2, String career_3, String career_4, String career_5) {
		this.user_id = user_id;
		this.career_1 = career_1;
		this.career_1 = career_2;
		this.career_1 = career_3;
		this.career_1 = career_4;
		this.career_1 = career_5;
	}
	
	
}
