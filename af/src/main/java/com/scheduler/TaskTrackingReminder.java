
package com.scheduler;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class TaskTrackingReminder {
	public static void main(String args[]){
		new TaskTrackingReminder().run();
	}

	private static final Logger logger = LoggerFactory.getLogger(TaskTrackingReminder.class);
	
	@Value("${mail.mailList:prat@iconext.co.th}")
	private String mailList="prat@iconext.co.th";

	public void run() {

		final String username = "prat@iconext.co.th";
		final String password = "asdf_4568";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "www.iconext.co.th");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("prat@iconext.co.th"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailList));
			//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("prat@iconext.co.th"));
			message.setSubject("Task Tracking Report 2015_Pratz");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			//String file = "/var/vcap.local/dea/apps/pratz-0-5c3a813f5ecdae4d0996206a1de5524a/tomcat/webapps/ROOT/uploaddata/Task Tracking Report 2014_Mr.Prat.xls";
			String fileName = "Task Tracking Report 2015_Mr.Prat.xls";
			File f = new File(System.getProperty("java.io.tmpdir") + "tmp.xls");
			f.deleteOnExit();
			FileUtils.copyURLToFile(new URL("http://pratz.ap01.aws.af.cm/resources/Task%20Tracking%20Report%202015_Mr.Prat.xls"), f);
			DataSource source = new FileDataSource(f);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText("-- \n" + "Best Regards,\n" + "Prat Nudklin\n" + "Senior System Developer\n" + "Mobile: 086-722-4100");
			multipart.addBodyPart(mbp1);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");
			java.awt.Toolkit.getDefaultToolkit().beep();
		} catch (Exception e) {
			logger.error("MessagingException", e);
		}
	}
	
	public void run2() {

		final String username = "prat@iconext.co.th";
		final String password = "asdf_4568";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "www.iconext.co.th");
		props.put("mail.smtp.port", "25");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("prat@iconext.co.th"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("pasuwat@iconext.co.th,pratz.nud@gmail.com"));
			//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("prat@iconext.co.th"));
			message.setSubject("Task Tracking Report 2015_Pratz");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			//String file = "/var/vcap.local/dea/apps/pratz-0-5c3a813f5ecdae4d0996206a1de5524a/tomcat/webapps/ROOT/uploaddata/Task Tracking Report 2014_Mr.Prat.xls";
			String fileName = "Task Tracking Report 2015_Mr.Prat.xls";
			File f = new File(System.getProperty("java.io.tmpdir") + "tmp.xls");
			f.deleteOnExit();
			FileUtils.copyURLToFile(new URL("http://pratz.ap01.aws.af.cm/resources/Task%20Tracking%20Report%202015_Mr.Prat.xls"), f);
			DataSource source = new FileDataSource(f);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText("-- \n" + "Best Regards,\n" + "Prat Nudklin\n" + "Senior System Developer\n" + "Mobile: 086-722-4100");
			multipart.addBodyPart(mbp1);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");
			java.awt.Toolkit.getDefaultToolkit().beep();
		} catch (Exception e) {
			logger.error("MessagingException", e);
		}
	}

}
