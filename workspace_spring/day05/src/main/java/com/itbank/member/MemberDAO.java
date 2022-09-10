package com.itbank.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired private SqlSessionTemplate sst;

	public List<MemberDTO> selectList() {
		List<MemberDTO> list = sst.selectList("itbank");
		
//		sst.selectList(statement);
//		별도의 매개변수 전달 없이 id만으로 호출하는 형식
		
//		sst.selectList(statement, parameter);
//		파라미터를 DTO 타입이나 HashMap 타입으로 지정하여 전달한다
		
//		sst.selectList(statement, parameter, rowBounds);
//		파라미터를 전달하면서 결과를 myBatis에 의해서 페이징 처리하여 가져온다
		
		return list;
	}

	public List<MemberDTO> selectList(String order) {
		List<MemberDTO> list = sst.selectList("selectOrder", order);
		return list;
	}

	public int insert(MemberDTO dto) {
		int row = sst.insert("insert", dto);
		return row;
	}
}
