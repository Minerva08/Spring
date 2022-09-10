package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BookDAO;

@Service
public class Paging {
	
	@Autowired
	private BookDAO dao;
	
	private int pageCount = dao.pageCount();
	private int section;
	
}
