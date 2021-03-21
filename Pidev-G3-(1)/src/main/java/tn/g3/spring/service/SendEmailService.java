package tn.g3.spring.service;
import java.io.File;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class SendEmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to, String topic,String body, File file) throws MessagingException
	{
		
		/*System.out.println("sending email");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("sonia.hadouej@esprit.tn");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(topic);
		 simpleMailMessage.setTex t(body,true);
		simpleMailMessage.setSentDate(new Date());
		javaMailSender.send(simpleMailMessage);
		System.out.println("sent email"); */

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		
		mimeMessageHelper.setFrom("sonia.hadouej@esprit.tn");
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setSubject(topic);
		mimeMessageHelper.setText(body,true);
		mimeMessageHelper.setSentDate(new Date());
		mimeMessageHelper.addAttachment(file.getName(), file);
		javaMailSender.send(mimeMessage);
		System.out.println("sent email"); 

	}
	
	
}
