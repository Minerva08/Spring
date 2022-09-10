package com.itbank.controller;

import java.text.DateFormat;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BookDTO;
import com.itbank.service.BookService;


@Controller
public class BookController {
	
	@Autowired private BookService bs;


	@GetMapping("/bookList")
	public ModelAndView bookList() {
		ModelAndView mav = new ModelAndView();
		List<BookDTO> list = bs.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/insert")		// 입력할 수 있는 페이지 (form) 을 화면에 띄워주면 끝
	public void insert() {}	
	
	@PostMapping("/insert")		// 입력한 내용을 DTO로 받아서, DAO에 전달하면 끝
	public String insert(BookDTO dto) {
		int row = bs.add(dto);
		System.out.println(row == 1 ? "성공" : "실패");
		return "redirect:/bookList";	// 추가되고 나서 목록에서 확인 할 수 있도록
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("update");
		BookDTO dto = bs.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(BookDTO dto) {
		int row = bs.update(dto);
		ModelAndView mav = new ModelAndView("redirect:/bookList");
		return mav;
	}
	
	
	
	
	
}
