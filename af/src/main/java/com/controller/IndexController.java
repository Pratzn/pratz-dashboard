package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{
  private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
  
  @RequestMapping(value={"/index.pratz"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(Model model)
  {
    logger.info("Welcome home!");
    
    return "index";
  }
}