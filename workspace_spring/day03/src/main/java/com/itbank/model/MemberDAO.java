package com.itbank.model;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	private RowMapper<MemberDTO> rowMapper = (ResultSet rs, int rownum) -> {
		MemberDTO ob = new MemberDTO();
		ob.setUserid(rs.getString("userid"));
		ob.setUserpw(rs.getString("userpw"));
		ob.setUsername(rs.getString("username"));
		ob.setEmail(rs.getString("email"));
		ob.setGender(rs.getString("gender"));
		return ob;
	};
	
	public MemberDTO login(MemberDTO dto) {
		String sql = "select * from member where userid=? and userpw=?";
		MemberDTO login = jt.queryForObject(sql, rowMapper, dto.getUserid(), dto.getUserpw());
		return login;
	}
}
