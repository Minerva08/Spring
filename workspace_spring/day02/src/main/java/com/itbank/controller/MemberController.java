package com.itbank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired private MemberService ms;

	@GetMapping("/join")
	public ModelAndView join(HttpServletRequest request) throws IOException {
		ModelAndView mav = new ModelAndView("join/step1");
		
		String path = request.getSession().getServletContext().getRealPath("resources/agreement.txt");
		System.out.println(path);
		
		String agreement = ms.getAgreement(path);
		mav.addObject("agreement", agreement);
		
		return mav;
	}
	
	@GetMapping("/join/step2")
	public ModelAndView join2(String agree, @RequestHeader("referer") String referer) {
		// @RequestHeader(name) = request.getHeader(name) 
		
		ModelAndView mav = new ModelAndView("join/step2");
		
		System.out.println("동의 : " + agree);
		System.out.println("referer : " + referer);
		
		if(agree == null) {
			mav.setViewName("alert");
			mav.addObject("msg", "약관에 동의하셔야 가입이 가능합니다");
			mav.addObject("url", referer);
		}
		return mav;
	}
	
	@PostMapping("/join/step3")
	public ModelAndView join3(MemberDTO dto) {
		System.out.println(dto);
		int row = ms.insert(dto);
		ModelAndView mav = new ModelAndView();
		
		if(row == 1) {
			mav.setViewName("redirect:/"); 	// viewName 의 시작이 redirect: 이면 리다이렉트로 처리함
			// 리다이렉트는 jsp를 가리키지 않고, 요청 주소를 가리킨다 -> @RequestMapping 과 매칭되어야 한다
		}
		else {
			mav.setViewName("alert");
			mav.addObject("msg", "회원 가입 실패 !!");
		}
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		List<MemberDTO> list = ms.getMemberList();
		mav.addObject("abcd", list);
		
		return mav;
	}
}
