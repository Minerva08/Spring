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

	public List<BookDTO> getList(HashMap<String, String> map) {
		return dao.selectList(map);
	}

	public int deleteBook(int idx) {
		return dao.delete(idx);
	}

	public BookDTO select(int idx) {
		return dao.select(idx);
	}

	public int modify(BookDTO dto) {
		return dao.update(dto);
	}

	public int insert(BookDTO dto) {
		return dao.insert(dto);
	}

}







