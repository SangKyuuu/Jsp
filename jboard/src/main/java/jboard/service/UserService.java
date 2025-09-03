package jboard.service;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jboard.dao.UserDAO;
import jboard.dto.UserDTO;

public enum UserService {
	INSTANCE;
	
	private final String SENDER = "bisunesskyu@gmail.com";
	private UserDAO dao = UserDAO.getInstance();
	
	public int sendEmailCode(String email) {
		// Gmail SMTP 서버 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		//6자리 인증코드 생성
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
				
		String title = "jboard 회원가입 이메일 인증코드";
	    String content = "인증번호는 " + code + "입니다.";
		
		//Gmail SMTP 세션 생성
		Session gmailSession = Session.getInstance(props, new Authenticator(){
			
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				String secret = "detvitlhtcjlqtah";
				return new PasswordAuthentication(SENDER, secret);
			}
			
		});
		
		//메일 발송
		Message message = new MimeMessage(gmailSession);
		
		try{
			
			message.setFrom(new InternetAddress(SENDER, "보내는사람", "UTF-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=UTF-8");
			
			//메일 발송
			Transport.send(message);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return code;
	}
	
	public void register(UserDTO dto) {
		dao.insert(dto);
	}
	
	public int getUserCount(String col, String value) {
		return dao.selectCount(col, value);
	}
	
	public UserDTO findByPass(UserDTO dto) {
		return dao.select(dto);
	}
	
	public List<UserDTO> findAll() {
		return dao.selectAll();
	}
	
	public void modify(UserDTO dto) {
		dao.update(dto);
	}
	
	public void remove(String usid) {
		dao.delete(usid);
	}
}	
