package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;
import com.itbank.model.BookDTO;

@Service
public class BookService {
	
	@Autowired private BookDAO dao;

	public List<BookDTO> getList() {
		List<BookDTO> list = dao.selectList();
		return list;
	}

	public int add(BookDTO dto) {
		int row = dao.insert(dto);
		return row;
	}

	public BookDTO selectOne(int idx) {
		BookDTO dto = dao.selectOne(idx);
		return dto;
	}

	public int update(BookDTO dto) {
		return dao.update(dto);
	}

}
