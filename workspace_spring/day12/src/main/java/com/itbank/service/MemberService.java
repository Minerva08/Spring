package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;

	public MemberDTO getMember(String userid) {
		
		return dao.selectMember(userid);
	}

	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		return dao.getMemberList();
	}

	public List<MemberDTO> getMemberListByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.getMemberListByUsername(username);
	}

	public int join(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.joinmember(dto);
	}

	

	

	
}
