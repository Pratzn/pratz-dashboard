package org.pratz.loading.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailSenderController {
	
	@RequestMapping(value={"/mail"})
	public String mail(Model model) throws IOException{
		return "mail";
	}
	
	@RequestMapping(value={"/mailSending"})
	public String send(Model model) throws IOException{
		model.addAttribute("msg","E-mail Sending . . .");
		return "mail";
	}

}
