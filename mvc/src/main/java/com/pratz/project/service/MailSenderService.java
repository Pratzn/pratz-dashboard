package com.pratz.project.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
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
	
	private String workspaceFolder;

	public final void setJavaMailSenderImpl(
			JavaMailSenderImpl javaMailSenderImpl) {
		this.javaMailSenderImpl = javaMailSenderImpl;
	}

	public void sendMail(String from, String to, String subject, String contents, MultipartFile[] multipartFiles) throws IOException {
		//String workspaceFolder = System.getProperty("java.io.tmpdir");
		workspaceFolder = "C:\\Users\\prat\\Desktop\\TestFile\\TTFL E-mail Temp Folder\\";
		MimeMessage message = javaMailSenderImpl.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(contents);
			String tempFolder = from+System.currentTimeMillis();
			File folder = new File(workspaceFolder+tempFolder);
			folder.mkdir();
			folder.deleteOnExit();
			for(int i = 0 ; i < multipartFiles.length ; i++){
				MultipartFile file = multipartFiles[i];
					String filePath = folder+"\\"+file.getOriginalFilename();
					File fileAttach = new File(filePath);
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(fileAttach));
					stream.write(bytes);
					stream.close();
					System.out.println(fileAttach.exists());
					System.out.println(fileAttach.isFile());
					System.out.println(fileAttach.canRead());
					fileAttach.deleteOnExit();
					helper.addAttachment(file.getOriginalFilename(), fileAttach);
			}
			javaMailSenderImpl.send(message);
			FileUtils.deleteDirectory(folder);
		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
	}

	public final void setEmailFolder(String emailFolder) {
		this.workspaceFolder = emailFolder;
	}

	



}
