package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex04Controller {
	
	@GetMapping("/ex04")
	public void abcd() {}
	//함수 이름은 반환형과 아무 상관이 없다
	//둘 다 DispatcherServlet을 통해서 전달하므로, 두 요소를 하나
	
	@PostMapping("/ex04")
	
	public ModelAndView ex04(MemberDTO dto) {
	ModelAndView mav = new ModelAndView("ex04Result");
		
	//ModelAndView mav = new ModelAndView();
	//mav.setViewName("ex04Result");
		mav.addObject("dto",dto);
		
		return mav;
	}
}
