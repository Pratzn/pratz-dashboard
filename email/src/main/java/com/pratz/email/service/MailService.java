package com.pratz.email.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;


@Component
public class MailService {
	
private static final String templateName="template.ftl";
	
	@Autowired
	private Configuration configuration;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String from, String to, String subject, String contents) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setPriority(1);
			
			try{
				Map<String,String> templateVars = new  HashMap<String,String>();
				templateVars.put("name", "Pratz");
				
				/*   ------- Sol. 1
				StringBuffer content = new StringBuffer();
				try {
				    content.append(FreeMarkerTemplateUtils.processTemplateIntoString(
				    		configuration.getTemplate(templateName), templateVars));
				} catch (IOException e) {
				    e.printStackTrace();
				} catch (TemplateException e) {
					  e.printStackTrace();
				}
				System.out.println(content.toString());
				*/
				
				
				/*------------Sol. 2            */
				String content = FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate(templateName,"UTF-8"), templateVars);
				System.out.println(content);
				helper.setText(content);
				}catch(Exception e){
					
					e.printStackTrace();
				}
			
		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
		javaMailSender.send(message);
	}

	public final void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public final void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
}
