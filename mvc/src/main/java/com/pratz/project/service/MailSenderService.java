package com.pratz.project.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class MailSenderService {

	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;

	public final void setJavaMailSenderImpl(
			JavaMailSenderImpl javaMailSenderImpl) {
		this.javaMailSenderImpl = javaMailSenderImpl;
	}

	public void sendMail(String from, String to, String subject, String contents, MultipartFile file) throws IOException {

		MimeMessage message = javaMailSenderImpl.createMimeMessage();
		
		String path = System.getProperty("java.io.tmpdir")
				+ file.getOriginalFilename() + System.currentTimeMillis();
		System.out.println(path);
		File tempEmail = new File(path);
		// tempEmail.
		
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path)));
			stream.write(bytes);
			stream.close();
			System.out.println(tempEmail.exists());
			System.out.println(tempEmail.isFile());
			System.out.println(tempEmail.canRead());

			tempEmail.deleteOnExit();

		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(from);

			helper.setTo(to);

			helper.setSubject(subject);

			helper.setText(contents);
			System.out.println(tempEmail.getName());
			helper.addAttachment(tempEmail.getName(), tempEmail);

		} catch (MessagingException e) {

			throw new MailParseException(e);

		}

		javaMailSenderImpl.send(message);

	}

}
