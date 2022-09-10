package com.itbank.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.BoardService;
import com.itbank.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired private MemberService ms;
	@Autowired private BoardService bs;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public ModelAndView login(MemberDTO dto, HttpSession se) {
		ModelAndView mav = new ModelAndView("alert");
		MemberDTO member = ms.login(dto);
		System.out.println(member);
		se.setAttribute("login",member );
		
		if(member!=null) {
			mav.setViewName("redirect:/");
		}
		else {
			mav.addObject("msg", "없는 회원입니다");
			mav.addObject("url","/login");
		}
		return mav;
	}
	
	@GetMapping("/board")
	public void board() {}
	
	
}
