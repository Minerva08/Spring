package com.itbank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BookDTO;
import com.itbank.service.BookService;

@Controller
public class HomeController {
	@Autowired
	private BookService bs;
	
	
	@GetMapping("/")
	public ModelAndView board() {
		
		ModelAndView mav = new ModelAndView("/book/list");
		List<BookDTO> list = bs.getList();
		mav.addObject("list",list);
		return mav;
	}
	
	
	@PostMapping("/")
	public ModelAndView search(@RequestParam String option,@RequestParam String search) {
		ModelAndView mav = new ModelAndView("/book/list");
		List<BookDTO> list = bs.getSearch(option, search);
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("book/regist")
	public void regist1() {}
	
	@PostMapping("/book/regist2")
	public ModelAndView regist2(BookDTO dto) {
		System.out.println(dto);
		int row = bs.registbook(dto);
		
		ModelAndView mav = new ModelAndView();
		
		if(row == 1) {
			mav.setViewName("redirect:/"); 	// viewName 의 시작이 redirect: 이면 리다이렉트로 처리함
			// 리다이렉트는 jsp를 가리키지 않고, 요청 주소를 가리킨다 -> @RequestMapping 과 매칭되어야 한다
		}
		else {
			mav.setViewName("alert");
			mav.addObject("msg", "도서등록 실패 !!");
		}
		return mav;
	}
	
	
}
