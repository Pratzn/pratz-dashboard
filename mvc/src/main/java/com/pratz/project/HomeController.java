package com.pratz.project;

import java.io.IOException;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.pratz.project.service.MailSenderService;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private MailSenderService mailSenderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String uploadForm() {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("file2") MultipartFile file2)
			throws IOException {

		if (!file.isEmpty() && !file2.isEmpty()) {

			mailSenderService
					.sendMail("prat.N.qt6@th.nssol.nssmc.com",
							"prat.N.qt6@th.nssol.nssmc.com", "Subject",
							"Content", new MultipartFile[]{file,file2});
		}

		return "upload";
	}

	public final void setMailService(MailSenderService mailSenderService) {
		this.mailSenderService = mailSenderService;
	}

}
