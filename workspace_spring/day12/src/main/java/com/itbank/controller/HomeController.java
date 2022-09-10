package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/ex01")
	public void ex01() {
		
	}
	
	@GetMapping("/ex02")
	public void ex02() {
		
	}
	
	@GetMapping("/ex03")
	public void ex03() {
	
	}
	@GetMapping("/ex04")
	public void ex04() {
		
	}
	@GetMapping("/quiz")
	public void quiz() {
		
	}
	@GetMapping("/quiz2")
	public void quiz2() {
		
	}
	
	@Autowired MemberService ms;
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = ms.join(dto);
		System.out.println(row == 1 ? "가입 성공" : "가입 실패");
		return "redirect:/";
	}
	
}
