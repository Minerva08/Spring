package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.controller.MemberDTO;

@Controller
public class Ex03Controller {
	
	@GetMapping("/ex03")
	public void ex03() {}
	//컨트롤러 메서드의 반환형이 void이면 @RequestMapping의 value가 viewName이 된다
	//=>요청 주소 그대로 jsp를 찾아간다
	
	@PostMapping("/ex03")
	public String ex03(MemberDTO dto,Model model) {
		model.addAttribute("dto",dto);
		return "ex03Result";
	}
	
	
}
