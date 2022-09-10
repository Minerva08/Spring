package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDAO;
import com.itbank.model.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

	public MemberDTO login(MemberDTO dto) {
		return dao.login(dto);
	}

}
