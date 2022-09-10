package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.TestDAO;
import com.itbank.model.TestDTO;

@Service
public class TestService {

	@Autowired private TestDAO dao;

	public List<TestDTO> getList() {
		return dao.selectList();
	}
	
	
}
