package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.book.BookDTO;
import com.itbank.service.BookService;

@Controller
public class BookController {

	@Autowired private BookService bs;
	
	@GetMapping("/bookList")
	public String bookList() {
		return "redirect:/bookList/idx";
	}
	
	@GetMapping("/bookList/{order}")
	public ModelAndView bookList(@RequestParam HashMap<String, String> map,
								 @PathVariable String order) {
		ModelAndView mav = new ModelAndView("bookList");
		
		map.put("order", order);
//		System.out.println("map : " + map);
//		HashMap을 이용하여 parameter를 받을 때는 어노테이션 @RequestParam을 생략하면 안된다
		
		List<BookDTO> list = bs.getList(map);
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/deleteBook/{idx}")	
	public ModelAndView deleteBook(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView("alert");
		int row = bs.deleteBook(idx);

		if(row == 1) {
			mav.addObject("msg", idx + "번 도서정보가 삭제되었습니다");
			mav.addObject("url", "bookList");
		}
		else {
			mav.addObject("msg", "삭제가 처리되지 않았습니다");
			// url을 지정하지 않으면 history.go(-1) 로 이전 페이지로 이동하도록
		}
		return mav;
	}
	
	@GetMapping("/modifyBook/{idx}")
	public ModelAndView modify(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView("modifyBook");
		BookDTO dto = bs.select(idx);	// 객체 하나의 정보를 불러와서
		mav.addObject("dto", dto);		// 넘겨주고, jsp에서 form 태그의 value값으로 활용한다
		return mav;
	}
	
	@PostMapping("/modifyBook/{idx}")
	public ModelAndView modify(BookDTO dto) {	// 사용자가 수정 이후 제출한 데이터를 dto로 받는다
		ModelAndView mav = new ModelAndView("alert");
		System.out.println("수정 도서의 번호 : " + dto.getIdx());
		int row = bs.modify(dto);
		if(row == 1) {
			mav.addObject("msg", "수정 성공 !!");
			mav.addObject("url", "bookList");
		}
		else {
			mav.addObject("msg", "수정 실패 !!");
		}
		return mav;
	}
	
	@GetMapping("/addBook")
	public void addBook() {
		System.out.println("2) 컨트롤러");
	}
	
	@PostMapping("/addBook")
	public ModelAndView addBook(BookDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		int row = bs.insert(dto);
		mav.addObject("msg", row == 1 ? "추가 성공" : "추가 실패");
		mav.addObject("url", row == 1 ? "bookList" : "");
		return mav;
	}
}













