package com.pratz.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pratz")
public class PratzController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String pratz(Model model) {
		model.addAttribute("test", "pratz method");
        return "pratz";
    }
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
    public String test(Model model) {
		model.addAttribute("test", "test method");
        return "pratz";
    }

}
