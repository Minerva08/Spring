package com.itbank.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.NoticeService;

@Controller
public class HomeController {
	@Autowired NoticeService ns;
	
	@GetMapping("/")
	public ModelAndView home() throws IOException {
		ModelAndView mav = new ModelAndView();
		String content = ns.getText();
		mav.setViewName("home");
		mav.addObject("content", content);
		
		return mav;
	}
	
	
}