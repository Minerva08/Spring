package com.itbank.service;

import java.util.List;
import java.util.UUID;

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
		MemberDTO login = dao.selectMember(dto);	// userid, userpw
		System.out.println("비밀번호로 찾은 계정 : " + login);
		return login;
	}

	public int join(MemberDTO dto) {
		return dao.insert(dto);
	}

	public MemberDTO findMemberByEmail(MemberDTO dto) {
		MemberDTO target = dao.selectMember(dto);	// userid, email
		System.out.println("이메일로 찾은 계정 : " + target);
		return target;
	}

	public String newPass(MemberDTO target) {
		String newPass = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
		// 새로운 UUID 생성 -> 			a124h6324-57235-lkasdgf11-12345
		// replaceAll("-", "") -> 	a124h632457235lkasdgf1112345
		// substring(0, 8) ->		a124h632
		target.setUserpw(newPass);
		int row = dao.update(target);		// 수정이 되었으면 newPass를 반환, 아니면 null을 반환
		System.out.println("수정 결과 : " + row);
		return row == 1 ? newPass : null;
	}

	public int update(MemberDTO dto) {
		return dao.update(dto);
		// 비밀번호 재발급때 구성했던 dao.update() 가 동적 쿼리문으로 구성되어 있어서
		// 별도로 과정을 새로 만들지 않아도, 기존의 함수를 호출하여 그대로 재사용이 가능했다
	}

}







