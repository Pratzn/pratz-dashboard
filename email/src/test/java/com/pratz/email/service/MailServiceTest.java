package com.pratz.email.service;

import java.io.IOException;

import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icegreen.greenmail.util.GreenMail;
import com.pratz.email.config.MailConfig;

import freemarker.template.Configuration;

@ContextConfiguration(classes = {MailConfig.class,MailService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MailServiceTest {

	@Autowired
	GreenMail  greenMail;
	
	@Autowired
	private Configuration configuration;
	
	
	@Autowired
	MailService mailService;
	
	@Before
	public void setup() {
		greenMail.start();
		log("greenMail start!!");
	}
	
	@Test
	public void test1() throws MessagingException, IOException{
		log("test1");
		mailService.sendMail("pratz@localhost", "pratz@localhost", "subject", "contents");
		log(greenMail.getReceivedMessages()[0].getSubject());
		//log(greenMail.getReceivedMessages()[0].);
	}
	
	@Test
	public void test2(){
		log("test2");
	} 
	
	@Test
	public void test3(){
		log("test3");
	} 

	@After
	public void tearDown() {
		greenMail.stop();
		log("greenMail stop!!");
	}
	
	@BeforeClass
	public static void before(){
		
	}
	
	public static void log(String log){
		System.out.println(log);
	}

}
