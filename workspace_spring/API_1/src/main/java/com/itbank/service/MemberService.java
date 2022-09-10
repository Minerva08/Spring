package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.member.MemberDAO;
import com.itbank.member.Memberdto;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;

	public Memberdto selectOne(Memberdto dto) {
		return dao.selectOne(dto);
	}

	public List<Memberdto> selectAll() {
		return dao.selectAll();
	}

//	public int insert(HashMap<String, String> map) {
	public int insert(Memberdto dto) {
//		Memberdto dto = new Memberdto();
//		
//		dto.setAddress(map.put("addr1", "addr1"));
		return dao.insert(dto);
	}
	
	
}
