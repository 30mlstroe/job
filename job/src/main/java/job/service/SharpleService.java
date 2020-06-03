package job.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import job.model.joinus.dao.JoinUsDAO;
import job.model.joinus.dto.JoinUsDTO;

@Service
public class SharpleService {
	@Autowired
	JoinUsDAO join;
	
	public String registSharpleService (JoinUsDTO newUser) throws IOException, NoSuchAlgorithmException, GeneralSecurityException{
		return join.sharpleRegister(newUser);
	}
	
	public Object logInSharpleService (String userId, String userPassword) throws IOException, NoSuchAlgorithmException, GeneralSecurityException{
		return join.sharpleLogIn(userId, userPassword);
	}
	
	public JoinUsDTO myPageSharpleService(String userEmail) throws IOException{
		return join.sharpleMyPage(userEmail);
	}
	
	public String updateMyPageSharpleService(JoinUsDTO newUserInfo) throws IOException, NoSuchAlgorithmException, GeneralSecurityException{
		return join.sharpleUpdateMyPage(newUserInfo);
	}
	
	public JoinUsDTO adminLogInService (String user_id, String userPassword) throws IOException{
		return join.adminLogIn(user_id, userPassword);
	}
	
	
}
