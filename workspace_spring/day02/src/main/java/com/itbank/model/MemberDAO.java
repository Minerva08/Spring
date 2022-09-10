package com.itbank.model;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired private JdbcTemplate jt;

	public int insert(MemberDTO dto) {
		String sql = "insert into member values (?, ?, ?, ?, ?)";
		return jt.update(sql, dto.getUserid(), dto.getUserpw(), dto.getUsername(), dto.getEmail(), dto.getGender());
	}
	

	public List<MemberDTO> selectList() {
		// SQL을 실행하기 위한 쿼리문
		String sql = "select * from member order by userid";
		
		// 결과를 받아서 어떻게 DTO에 맵핑할 것인가 결정하는 함수를 객체 형태로 생성
		RowMapper<MemberDTO> mapper = (ResultSet rs, int rownum) -> {
			// JSP DAO에서 while문 내부에 작성하던 코드를 그대로 작성
			MemberDTO dto = new MemberDTO();
			dto.setUserid(rs.getString("userid"));
			dto.setUserpw(rs.getString("userpw"));
			dto.setUsername(rs.getString("username"));
			dto.setEmail(rs.getString("email"));
			dto.setGender(rs.getString("gender"));
			return dto;
		};
		
		// sql문과 mapper 함수객체를 전달하면 jdbcTemplate 이 쿼리문을 수행하고 알아서 결과를 반환함
		// 이때, jt.query()는 List<T> 를 반환하고, jt.queryForObject() 는 T 를 반환한다
		List<MemberDTO> list = jt.query(sql, mapper);
		
		// 받아온 list를 반환
		return list;
	}
}
