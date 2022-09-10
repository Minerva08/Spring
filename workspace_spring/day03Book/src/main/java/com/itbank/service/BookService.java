package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;
import com.itbank.model.BookDTO;

@Service
public class BookService {

	@Autowired
	private BookDAO bd;
	
	public List<BookDTO> getList() {
		
		return bd.getList();
	}
	
	public List<BookDTO> getSearch(String option, String search){
		return bd.search(option,search);
	}

	public int registbook(BookDTO dto) {
		return bd.regist(dto);
	}
	
}
