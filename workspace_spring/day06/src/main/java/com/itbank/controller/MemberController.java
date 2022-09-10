package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired private MemberService ms;

	@GetMapping("/memberList")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = ms.getMemberList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/loginTest") 
	public void loginTest() {}
	
	@PostMapping("/loginTest")
	public String loginTest(MemberDTO dto) {
		MemberDTO login = ms.login(dto);
		System.out.println(login == null ? "실패" : "성공 : " + login.getUserid());
		return "redirect:/";
	}
}









