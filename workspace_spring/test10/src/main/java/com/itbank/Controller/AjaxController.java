package com.itbank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.BookDTO;
import com.itbank.service.BookService;



@RestController
public class AjaxController {

	@Autowired private BookService bs;
	
	@GetMapping("/BookList")
	public List<BookDTO> ajaxProductList() {
		return bs.getList();
	}
}
