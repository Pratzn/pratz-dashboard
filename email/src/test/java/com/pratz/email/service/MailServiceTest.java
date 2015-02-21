package com.pratz.email.service;

import java.io.IOException;
import java.util.Enumeration;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icegreen.greenmail.util.GreenMail;

import freemarker.template.Configuration;

//@ContextConfiguration(classes = {MailConfig.class,MailService.class})
@ContextConfiguration({ "MailServiceTest-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MailServiceTest {

	@Autowired
	GreenMail greenMail;

	@Autowired
	Configuration configuration;

	@Autowired
	MailService mailService;

	@Before
	public void setup() {
		greenMail.start();
		log("greenMail start!!");
	}

	@Test
	public void test1() throws MessagingException, IOException {
		log("test1");
		mailService.sendMail("pratz@localhost", "pratz@localhost", "subject",
				"contents");

		MimeMessage[] mineMessages = greenMail.getReceivedMessages();
		for (MimeMessage mimeMessage : mineMessages) {
			log("------------------------------------");
			log("   from : ");
			Address[] from = mimeMessage.getFrom();
			for (Address address : from) {
				log("                " + address.toString());
			}
			log("   subject : " + mimeMessage.getSubject());
			log("   content : "
					+ mimeMessage.getDataHandler().getContent().toString());
			log("   header : ");
			Enumeration<?> e = mimeMessage.getAllHeaderLines();
			while (e.hasMoreElements()) {
				log("                 "+e.nextElement().toString());
			}
			log("------------------------------------");
		}
	}

	@Test
	public void test2() {
		log("test2");
	}

	@Test
	public void test3() {
		log("test3");
	}

	@After
	public void tearDown() {
		greenMail.stop();
		log("greenMail stop!!");
	}

	@BeforeClass
	public static void before() {

	}

	public static void log(String log) {
		System.out.println(log);
	}

}
