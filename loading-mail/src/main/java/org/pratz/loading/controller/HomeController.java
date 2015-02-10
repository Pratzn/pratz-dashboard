package org.pratz.loading.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value={"/","/home"})
	public String test() throws IOException{
		return "home";
	}
	
	@RequestMapping(value="/loading1",method=RequestMethod.GET)
	public String loading1get(Model model) throws IOException{
		return "loading1";
	}
	
	@RequestMapping(value="/loading1", method=RequestMethod.POST)
	public String loading1post(Model model) throws IOException{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "loading1";
	}
	
	
	@RequestMapping(value="/popup")
	public String popup(Model model) throws IOException{
		return "popup";
	}
	
	@RequestMapping(value="/popup1")
	public String popup1(Model model) throws IOException{
		return "popup1";
	}
	/*
	@ModelAttribute
	public void store(Model model){
		System.out.println("------------------Show Model---------------------------");
		Map<String, Object> map =model.asMap();
		for(String key:map.keySet()){
			if(key.startsWith("org.springframework")){
				continue;
			}
			System.out.println("model['"+key+"'] = "+map.get(key));
			System.out.println();
			System.out.println();
		}
		
	}
	
	@ModelAttribute
	public void store(HttpServletRequest request){
		System.out.println("------------------Show Attribute---------------------------");
		Enumeration<?> e =request.getAttributeNames();
		while(e.hasMoreElements()){
			String key = (String) e.nextElement();
			if(key.startsWith("org.springframework")){
				continue;
			}
			System.out.println("attribute['"+key+"'] = "+request.getAttribute(key));
			System.out.println();
			System.out.println();
		}
	}
	
	@ModelAttribute
	public void param(HttpServletRequest request,ModelMap model){
		System.out.println("------------------Show Parameter---------------------------");
		Enumeration<?> e =request.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String) e.nextElement();
			if(key.startsWith("org.springframework")){
				continue;
			}
			model.addAttribute(key, request.getParameter(key));
			System.out.println("Parameter['"+key+"'] = "+request.getParameter(key));
			System.out.println();
			System.out.println();
		}
	}
	
	*/
	
}
