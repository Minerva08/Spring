package com.itbank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.image.UploadDTO;
import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;
import com.itbank.service.UploadService;

@Controller
public class HomeController {
	
	@Autowired	// 스프링 빈으로 등록된 객체만 자동으로 의존 주입이 가능하다
	private UploadService us;
	
	@Autowired 
	private MemberService ms; 
	
	// 목록 출력, 업로드 폼 표시, (로그인)
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<UploadDTO> list = us.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	// 업로드 처리만 하고 목록페이지로 리다이렉트
	@PostMapping("/upload")
	public String upload(UploadDTO dto) throws IllegalStateException, IOException {
		int row = us.upload(dto);
		System.out.println(row == 1 ? "업로드 성공" : "업로드 실패");
		return "redirect:/";	// 바로 위에 있는 home()을 다시 호출하도록
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberDTO dto, HttpSession session) {
		MemberDTO login = ms.login(dto);
		session.setAttribute("login", login);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}