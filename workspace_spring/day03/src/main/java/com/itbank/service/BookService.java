package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;
import com.itbank.model.BookDTO;

@Service
public class BookService {
	
	@Autowired
	private BookDAO dao;

	public List<BookDTO> list() {
		return dao.list();
	}

	public int insert(BookDTO dto) {
		return dao.insert(dto);
	}

	public List<BookDTO> searchlist(String choice, String search) {
		return dao.searchlist(choice, search);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public int modify(BookDTO dto, int idx) {
		return dao.modify(dto, idx);
	}

	public Paging paging(int nowpage) {
		return dao.paging(nowpage);
	}

	
}
