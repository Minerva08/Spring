package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.book.BookDTO;
import com.itbank.service.BookService;

@Controller
public class BookController {

	@Autowired private BookService bs;
	
	@GetMapping("/bookList")
	public String bookList() {
//		return bookList("idx");
		return "redirect:/bookList/idx";
	}
	
	@GetMapping("/bookList/{order}")
	public ModelAndView bookList(@PathVariable String order) {
		ModelAndView mav = new ModelAndView("bookList");
		List<BookDTO> list = bs.getList(order);
		mav.addObject("list", list);
		return mav;
	}
}
