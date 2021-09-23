package com.shamik.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailsender;
	public void sendSimpleEmial(String toEmail, String body, String subject)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("shamiksarkar2012@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailsender.send(message);
		System.out.println("mail send..");
	}

}
