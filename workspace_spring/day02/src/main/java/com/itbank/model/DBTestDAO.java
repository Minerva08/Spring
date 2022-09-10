package com.itbank.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DBTestDAO {
	
	@Autowired private JdbcTemplate jt;

	public String selectVersion() {
		String sql = "select banner from v$version";
//		RowMapper<String> rowMapper = (ResultSet rs, int rowNum) -> {
//			return rs.getString("banner");
//		};	// 람다식을 활용한 함수형 인터페이스 객체 생성
		
		RowMapper<String> rowMapper = new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("banner");
			}
		};	// 추상 클래스를 상속받는 익명클래스 객체 생성
		String result = jt.queryForObject(sql, rowMapper);
		return result;
	}

}
