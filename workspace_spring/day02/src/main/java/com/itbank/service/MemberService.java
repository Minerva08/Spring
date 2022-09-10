package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDAO;
import com.itbank.model.MemberDTO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	
	public String getAgreement(String path) throws IOException {
		String agreement = "";
		File f = new File(path);
		
		if(f.exists() == false) {
			System.out.println("파일이 없습니다 !!");
			return null;
		}
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			agreement += sc.nextLine() + "\n";
		}
		sc.close();
		return agreement;
	}

	public int insert(MemberDTO dto) {
		// 나중에 비밀번호 값을 해시처리하는 코드 추가 예정
		return dao.insert(dto);
	}

	public List<MemberDTO> getMemberList() {
		return dao.selectList();
	}
}
