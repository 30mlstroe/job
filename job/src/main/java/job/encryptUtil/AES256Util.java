package job.encryptUtil;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
@Component
public class AES256Util {
   private String iv;
   private Key keySpec;
   
   final static String key = "sharple_secret_key"; // 비밀 키
   
   // java.security.InvalidKeyException: Illegal key size 에러 -> 키값의 길이가 부족할 때 나는 에러
   
   public AES256Util() throws UnsupportedEncodingException {
      this.iv = key.substring(0, 16);
      byte[] keyBytes = new byte[16];
      byte[] b = key.getBytes("UTF-8");
      int len = b.length;
      if (len > keyBytes.length) {
         len = keyBytes.length;
      }
      System.arraycopy(b, 0, keyBytes, 0, len);
      SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

      this.keySpec = keySpec;
   }

   /**
    * AES256 으로 암호화 한다.
    * 
    * @param str 암호화할 문자열
    * @return 암호화된 문자열
    * @throws NoSuchAlgorithmException
    * @throws GeneralSecurityException
    * @throws UnsupportedEncodingException
    */
   public String encrypt(String str) throws NoSuchAlgorithmException,
         GeneralSecurityException, UnsupportedEncodingException {
      Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
      c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
      byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
      String enStr = new String(Base64.encodeBase64(encrypted));
      return enStr;
   }

   /**
    * AES256으로 암호화된 txt 를 복호화한다.
    * 
    * @param str 복호화할 문자열
    * @return 복호화된 문자열
    * @throws NoSuchAlgorithmException
    * @throws GeneralSecurityException
    * @throws UnsupportedEncodingException
    */
   public String decrypt(String str) throws NoSuchAlgorithmException,
         GeneralSecurityException, UnsupportedEncodingException {
      Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
      c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
      try {
    	  byte[] byteStr = Base64.decodeBase64(str.getBytes());
    	  return new String(c.doFinal(byteStr), "UTF-8");
		
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}
   }
}