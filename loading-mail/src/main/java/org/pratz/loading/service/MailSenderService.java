
package org.pratz.loading.service;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void setJavaMailSender(final JavaMailSender javaMailSender) {

		this.javaMailSender = javaMailSender;
	}

	/*
	public static void main(String args[]){
		MailSenderService mail = new MailSenderService();
		mail.sendMail();
		
	}
	*/
	//String from, String to, String subject, String contents
	public void sendMail() {

		MimeMessage message = javaMailSender.createMimeMessage();

		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setCc("pasuwat@iconext.co.th,prat@iconext.co.th");
			helper.setTo("pasuwat@iconext.co.th,prat@iconext.co.th");
			helper.setFrom("pasuwat@iconext.co.th,prat@iconext.co.th");
			helper.setSubject("Test");
			helper.setText("<p><font size='80px'>PaaS : Pratz as a Service</font></p>", true);

			Calendar c = Calendar.getInstance();
			c.add(Calendar.YEAR, 10);
			Date d = c.getTime();
			System.out.println(d);
			helper.setSentDate(d);
			DataSource source = null;
			
			File f = new File(System.getProperty("java.io.tmpdir") + "tmp.xls");
			f.deleteOnExit();
			FileUtils.copyURLToFile(new URL("http://mpics.manager.co.th/pics/Images/558000001686301.JPEG"), f);
			source = new FileDataSource(f);
			
			helper.addAttachment(source.getName(), source);

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		javaMailSender.send(message);
	}

}
