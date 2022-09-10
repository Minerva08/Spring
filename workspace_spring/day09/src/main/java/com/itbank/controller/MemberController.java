package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = ms.join(dto);
		System.out.println(row == 1 ? "가입 성공" : "가입 실패");
		return "redirect:/login";
	}
	
	@GetMapping("/login") 
	public void login() {}
	
	@PostMapping("/login")	// POST라도 주소창에 쿼리스트링이 있으면 파라미터 형식으로 받을 수 있다 !!
	public String login(MemberDTO dto, HttpSession session, String url) {
		System.out.println("컨트롤러에서 받은 주소 : " + url);
		
		MemberDTO login = ms.login(dto);		// DB에서 받아온 계정을
		session.setAttribute("login", login);	// 현재 세션에 저장
		System.out.println(login == null ? "실패" : "성공 : " + login.getUserid());
		
		// 요청받은 주소가 별도로 있으면, 그 주소로 이동시키고 아니면 대문페이지로 이동시킨다
		return (url == null) ? "redirect:/" : "redirect:" + url;
		
								//cpath
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/memberInfo")
	public ModelAndView memberInfo(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberInfo"); 	// 생성자 매개변수로 넣지 않는다면 setter를 활용할수 있다
		
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		MemberDTO info = ms.login(login);	// 차후 보안요소를 생각한다면, 비번을 한번 더 입력받는 것이 맞다
		mav.addObject("info", info);
		
		return mav;
	}
	
	@GetMapping("/memberUpdate")
	public ModelAndView memberUpdate(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		MemberDTO info = ms.login(login);
		mav.addObject("info", info);
		return mav;
	}
	
	@PostMapping("/memberUpdate")
	public ModelAndView memberUpdate(MemberDTO dto, HttpSession session) {
		int row = ms.update(dto);
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", row == 1 ? "수정 성공" : "수정 실패");
		mav.addObject("url", row == 1 ? "login" : "");
		if(row == 1)	session.removeAttribute("login");
		return mav;
	}
	
	@GetMapping("/newPass")
	public void newPass() {}
	
	@PostMapping("/newPass")
	public ModelAndView newPass(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		
		// ID와 Email이 일치하는 계정이 있는가
		MemberDTO target = ms.findMemberByEmail(dto);
		
		if(target != null) {
			// 계정이 있으면, 새로 문자열을 만들어서 update 하고
			String newPass = ms.newPass(target);
			
			// 사용자에게 신규 비밀번호를 alert을 통해서 알려주기
			// 로그인 페이지로 이동
			mav.addObject("msg", "변경된 비밀번호는 [" + newPass + "] 입니다");
			mav.addObject("url", "/login");
		}
		else {
			// 일치하는 계정이 없다는 메시지를 alert을 통해서 알려주기
			// 이전페이지로 이동
			mav.addObject("msg", "입력한 정보와 일치하는 계정이 없습니다");
		}
		return mav;
	}
	
	@ExceptionHandler(DuplicateKeyException.class)	// PK나 UK가 중복되어 발생하는 예외
	public ModelAndView duplicateJoin(DuplicateKeyException e) {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", "이미 사용중인 ID입니다. 다른 ID로 가입을 시도해 주세요");
		return mav;
	}
}









