package nit.mca5.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	public EmailUtil() {
		// TODO Auto-generated constructor stub
	}
	

	public static boolean sendEmail(String email_id,String msg,String subject) throws MessagingException{
		boolean result=false;
		
		final String senderEmailUser ="bookbankernitrr";
		final String password ="amitaman";
		//System.out.println("read password");

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		System.out.println("PasswordAuthentication start....");

		Session email_session = Session.getInstance(props,
		new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(senderEmailUser, password);
		}
		});

			Message message = new MimeMessage(email_session);
	
			message.setFrom(new InternetAddress(senderEmailUser));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_id));
			
			message.setSubject(subject);
			message.setText("Your OTP for OPAS is :"+msg+"\n date :"+new Date());
			System.out.println("message sending....");
			Transport.send(message);
			System.out.println("message sent ");
			result=true;
		
		return result;
	}//sendEmail
}
