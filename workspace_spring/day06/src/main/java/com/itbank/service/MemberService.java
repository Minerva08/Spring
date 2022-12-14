package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.member.MemberDAO;
import com.itbank.member.MemberDTO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = dao.selectList();
		
		// 리스트 내부의 각 객체에 대해서, 비밀번호의 첫글자를 제외한 나머지를 *로 변경하여 반환
		for(MemberDTO dto : list) {
			String pass = dto.getUserpw();
			String newPass = pass.charAt(0) + "";
			for(int i = 0; i < pass.length() - 1; i++) {
				newPass += "*";
			}
			dto.setUserpw(newPass);
		}
		return list;
	}

	public MemberDTO login(MemberDTO dto) {
		MemberDTO login = dao.selectMember(dto);
		return login;
	}

}







