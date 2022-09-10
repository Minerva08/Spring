package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.DBTestDAO;

@Service	// 스프링 빈으로 등록하는 어노테이션
public class DBTestService {
	
	@Autowired private DBTestDAO dao;
	
	public String getTest() {
		//return "메롱";
		return dao.selectVersion();
	}

}
