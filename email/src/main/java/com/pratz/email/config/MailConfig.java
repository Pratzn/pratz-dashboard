package com.pratz.email.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

@Configuration
@ImportResource({"classpath*:beans.xml"})
public class MailConfig {
	@Bean
	public JavaMailSender javaMailSender(){
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("localhost");
		javaMailSender.setPort(25);
		javaMailSender.setUsername("pratz@localhost");
		javaMailSender.setPassword("pass");
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		//prop.put("mail.debug", "true");
		//prop.put("mail.smtp.starttls.enable","true" );
		javaMailSender.setJavaMailProperties(prop);
		return javaMailSender;
	}
	
	@Bean
	public GreenMail greenMail(){
		GreenMail greenMail = new GreenMail(ServerSetup.SMTP_POP3);
		greenMail.setUser("pratz@localhost", "pratz", "pass");
		Properties users = new Properties();
		users.put("pratz@localhost", "pass");
		greenMail.setUsers(users);
		return greenMail;
	}

}
