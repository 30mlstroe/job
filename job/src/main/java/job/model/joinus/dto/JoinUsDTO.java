package job.model.joinus.dto;

import lombok.Data;

// 회원가입 & 로그인을 위한 DTO
@Data
public class JoinUsDTO {
	private String user_id;
	private String user_name;
	private String user_email;
	private String user_pw;
	private String user_phone;
	
}
