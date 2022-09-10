package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.book.BookDAO;
import com.itbank.book.BookDTO;

@Service
public class BookService {
	
	@Autowired private BookDAO dao;

	public List<BookDTO> getList(String order	/*, String column, String word*/) {
//		HashMap<String, String> param = new HashMap<String, String>();
//		param.put("order", order);
		return dao.selectList(order);
	}

}
