package job.model.joinus.dao;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import job.encryptUtil.AES256Util;
import job.model.elk.dao.ESRequest;
import job.model.elk.dao.ESResponse;
import job.model.joinus.dto.JoinUsDTO;

@Component
public class JoinUsDAO {
	@Autowired
	AES256Util aes;

	@Autowired
	ESRequest req;

	@Autowired
	ESResponse rep;

	// 회원 가입 DAO
	public String sharpleRegister(JoinUsDTO newUser)
			throws IOException, NoSuchAlgorithmException, GeneralSecurityException {
		String registResult = "";
		newUser.setUser_email(aes.encrypt(newUser.getUser_email()));
		newUser.setUser_id(newUser.getUser_id());
		newUser.setUser_name(aes.encrypt(newUser.getUser_name()));
		newUser.setUser_phone(aes.encrypt(newUser.getUser_phone()));
		newUser.setUser_pw(aes.encrypt(newUser.getUser_pw()));
		String docId = rep.searchDocIdSharpleByUserIDRes(req.searchDocIdSharpleByUserIDReq(newUser.getUser_id()));
		if (false == rep.checkAlreadyExistedUserByDocIdRes(req.checkAlreadyExistedUserByDocIdReq(docId))) {
			registResult = rep.registSharpleRes(req.registSharpleReq(newUser));
		} else {
			return "ID";
		}
		return registResult;
	}

	// 로그인
	public Object sharpleLogIn(String userId, String userPassword)
			throws IOException, NoSuchAlgorithmException, GeneralSecurityException {
		JoinUsDTO userInfo = rep.loginSharpleRes(req.loginSharpleReq(userId));
		System.out.println();
		userInfo.setUser_email(aes.decrypt(userInfo.getUser_email()));
		userInfo.setUser_id(userInfo.getUser_id());
		userInfo.setUser_name(aes.decrypt(userInfo.getUser_name()));
		userInfo.setUser_phone(aes.decrypt(userInfo.getUser_phone()));
		userInfo.setUser_pw(aes.decrypt(userInfo.getUser_pw()));
		if (userId.equals(userInfo.getUser_id()) && userPassword.equals(userInfo.getUser_pw())) {
			return userInfo;
		} else {
			return "fail";
		}
	}

	// 회원정보 가져오기 (마이페이지)
	public JoinUsDTO sharpleMyPage(String userId) throws IOException {
		return rep.myPageSharpleRes(req.loginSharpleReq(userId));
	}

	// 회원정보 수정
	public String sharpleUpdateMyPage(JoinUsDTO userInfo)
			throws IOException, NoSuchAlgorithmException, GeneralSecurityException {
		userInfo.setUser_email(aes.encrypt(userInfo.getUser_email()));
		userInfo.setUser_id(userInfo.getUser_id());
		userInfo.setUser_name(aes.encrypt(userInfo.getUser_name()));
		userInfo.setUser_phone(aes.encrypt(userInfo.getUser_phone()));
		userInfo.setUser_pw(aes.encrypt(userInfo.getUser_pw()));
		return rep.updateSharpleRes(req.updateSharpleReq(userInfo));
	}

	// admin
	public JoinUsDTO adminLogIn(String user_id, String userPassword) throws IOException {
		JoinUsDTO userInfo = rep.adminLoginRes(req.adminLoginReq(user_id));
		System.out.println(userInfo);
		if (user_id.equals(userInfo.getUser_id()) && userPassword.equals(userInfo.getUser_pw())) {
			return userInfo;
		} else {
			return null;
		}
	}

}
