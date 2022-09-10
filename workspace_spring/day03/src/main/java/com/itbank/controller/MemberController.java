package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService ms;
	
	@GetMapping("/member/login")
	public void login() {}
	
	@PostMapping("/member/login")
	public String login(MemberDTO dto, HttpSession se) {
		MemberDTO login = ms.login(dto);
		se.setAttribute("login", login);
		return "redirect:/";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession se) {
		se.invalidate();
		return "redirect:/";
	}
}
