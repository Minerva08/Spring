package com.itbank.API_1;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.member.Memberdto;
import com.itbank.service.MemberService;

@Controller
public class LoginController {

	@Autowired private MemberService ms;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public ModelAndView login(HttpSession session, Memberdto dto) {
		ModelAndView mav = new ModelAndView();
		Memberdto login = ms.selectOne(dto);
		
		session.setAttribute("login", login);
		
		System.out.println(login != null ? "로그인성공" : "로그인 실패");
		mav.setViewName("redirect:/");
		
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<Memberdto> list = ms.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	@GetMapping("/join")
	public void insert() {}
	
	@PostMapping("/join") //HashMap<String, String> map
	public ModelAndView insert(Memberdto dto,
			String addr1, String addr2, String addr3, String addr4) {
		ModelAndView mav = new ModelAndView();
		
		String addr = addr1 + addr2 + addr3 + addr4;
		
		dto.setAddress(addr);
		
		int add = ms.insert(dto);
		
//		System.out.println(map.put("addr1","addr1"));
//		System.out.println(map.put("addr2","addr2"));
//		System.out.println(map.put("addr3","addr3"));
//		System.out.println(map.put("addr4","addr4"));
		
		System.out.println(add == 1 ? "가입성공" : "실패" );
		
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@GetMapping("/addr")
	public void addr() {}
	
	
	
	
}
