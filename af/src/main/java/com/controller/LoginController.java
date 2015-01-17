package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
  private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
  
  @RequestMapping(value={"/login"})
  public String login(@RequestParam(value="error", required=false) String error,@RequestParam(value="email", required=false) String email,@RequestParam(value="remember", required=false) String remember,@RequestParam(value="password", required=false) String password,ModelMap model,HttpSession session,HttpServletResponse response )
  {
      if("pratz.nud@gmail.com".equals(email) && "asdfasdf".equals(password)){
          logger.info("Welcome pratz!");
          logger.info("Remeber: "+remember);
          if(remember!=null){
              Cookie c = new Cookie("USER", "Pratz");
              response.addCookie(c);
          }
          session.setAttribute("USER", "Pratz");
          return "home";
      }else{
    	  if(error==null){
    		logger.error("Login fail!!");
          	model.addAttribute("loginMsg", "Username or password has invalid.");
          }else{
        	  logger.error("error parameter found");
        	  model.addAttribute("loginMsg", "Username or password has invalid.");
          }
          return "login";
      }
  }
}