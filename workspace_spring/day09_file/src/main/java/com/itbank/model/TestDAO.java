package com.itbank.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component		// @Repository 는 내부에서 발생하는 모든 예외를 DataExcessException 으로 처리하는 특징이 있다
public class TestDAO {

	// 스프링 빈이므로 서버가 재시작하면 내부 데이터가 초기화된다 (유지되지 않는다 == 영속성을 만족하지 않는다)
	private ArrayList<TestDTO> list = new ArrayList<TestDTO>();

	public int insert(TestDTO dto) {
		boolean result = list.add(dto);	// 추가하고 결과를 저장
		System.out.println("리스트에 들어있는 객체의 개수 : " + list.size());
		return result ? 1 : 0;
	}

	public List<TestDTO> selectList() {
		return list;
	}
	
	
}
