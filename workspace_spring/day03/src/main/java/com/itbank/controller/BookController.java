package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BookDTO;
import com.itbank.service.BookService;
import com.itbank.service.Paging;

@Controller
public class BookController {
	
	@Autowired
	private BookService bs;
	
	@GetMapping("/book/list")
	public ModelAndView list(int nowpage) {
		ModelAndView mav = new ModelAndView();
		List<BookDTO> list = bs.list();
		Paging paging = bs.paging(nowpage);		
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/book/insert")
	public void insert() {}
	
	@PostMapping("/book/insert")
	public ModelAndView insert(BookDTO dto) {
		int row = bs.insert(dto);
		ModelAndView mav = new ModelAndView("alert");
		if (row == 1) {
			mav.addObject("msg", "등록 되었습니다");
			mav.addObject("url", "/book/list");
		}
		else {
			mav.addObject("msg", "등록 실패");
			mav.addObject("url", "/book/insert");
		}
		return mav;
	}
	
	@GetMapping("/book/searchlist")
	public void searchlist() {}
	
	@PostMapping("/book/searchlist")
	public ModelAndView searchlist(String choice, String search) {
		ModelAndView mav = new ModelAndView();
		List<BookDTO> list = bs.searchlist(choice, search);
		mav.addObject("list", list);
		mav.addObject("choice", choice);
		mav.addObject("search", search);
		return mav;		
	}
	
	@GetMapping("/book/delete")
	public ModelAndView delete(int idx, String login) {
		ModelAndView mav = new ModelAndView();
		if (login != "") {
			int row = bs.delete(idx);
			if (row == 0) {
				mav.setViewName("alert");
				mav.addObject("msg", "삭제 실패 했습니다");
				mav.addObject("url", "/book/list");
			}
		}
		else {
			mav.setViewName("alert");
			mav.addObject("msg", "관리자가 아니거나 접근 권한이 없습니다");
			mav.addObject("url", "/book/list");
		}
		return mav;
	}
	
	@GetMapping("/book/searchdelete")
	public ModelAndView searchdelete(int idx, String login, String choice, String search) {
		ModelAndView mav = new ModelAndView();
		if (login != "") {
			int row = bs.delete(idx);
			List<BookDTO> list = bs.searchlist(choice, search);
			mav.addObject("list", list);
			mav.addObject("choice", choice);
			mav.addObject("search", search);
			mav.setViewName("/book/searchlist");
			if (row == 0) {
				mav.setViewName("alert");
				mav.addObject("msg", "삭제 실패 했습니다");
				mav.addObject("url", "/book/list");
			}
		}
		else {
			mav.setViewName("alert");
			mav.addObject("msg", "관리자가 아니거나 접근 권한이 없습니다");
			mav.addObject("url", "/book/list");
		}
		return mav;
	}
	
	@GetMapping("/book/modify")
	public ModelAndView modify(String login) {
		ModelAndView mav = new ModelAndView();
		if (login == "") {
			mav.setViewName("alert");
			mav.addObject("msg", "관리자가 아니거나 접근 권한이 없습니다");
			mav.addObject("url", "");
		}
		return mav;
	}
	
	@PostMapping("/book/modify")
	public ModelAndView modify(BookDTO dto, int idx) {
		ModelAndView mav = new ModelAndView("alert");
		int row = bs.modify(dto, idx);
		mav.addObject("msg", "수정 되었습니다");
		mav.addObject("url", "/book/list");
		if (row == 0) {
			mav.addObject("msg", "수정 실패 했습니다");
			mav.addObject("url", "/book/list");
		}
		return mav;
	}
}
