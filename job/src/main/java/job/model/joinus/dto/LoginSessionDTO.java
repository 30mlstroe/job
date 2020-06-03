package job.model.joinus.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lombok.Data;
import lombok.ToString;

//scope_session : 세션 객체가 생명주기를 갖도록 Bean scope로 설정
//proxy_mode : Bean Scope를 session으로 설정할 경우에는 proxyMode를 TARGE_CLASS로 설정해주어야 함.

@Data
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@ToString
public class LoginSessionDTO {
	private String user_id;
	private String user_name;
	private String user_email;
	private String user_pw;
	private String user_phone;
}
