package com.itbank.model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

	@Autowired
	private JdbcTemplate jt;
	
	// mapper 함수객체를 멤버 필드로 선언해두면, select 함수에서 참조만 시키면 된다
	private RowMapper<BookDTO> rowMapper = (ResultSet rs, int rownum) -> {
		// JSP DAO에서 while문 내부에 작성하던 코드를 그대로 작성
		BookDTO ob = new BookDTO();
		ob.setIdx(rs.getInt(1));
		ob.setName(rs.getString(2));
		ob.setAuthor(rs.getString(3));
		ob.setPublisher(rs.getString(4));
		ob.setPublishDate(rs.getDate(5));
		ob.setPrice(rs.getInt(6));
		ob.setDescription(rs.getString(7));
		
		return ob;
		// 결과를 받아서 어떻게 DTO에 맵핑할 것인가 결정하는 함수를 객체 형태로 생성
		// sql문과 mapper 함수객체를 전달하면 jdbcTemplate 이 쿼리문을 수행하고 알아서 결과를 반환함
		// 이때, jt.query()는 List<T> 를 반환하고, jt.queryForObject() 는 T 를 반환한다
	};
	
	public List<BookDTO> getList() {
		String sql = "select * from book order by idx";
		return jt.query(sql, rowMapper);
	}

	public List<BookDTO> search(String option, String search) {
		String sql = "select * from book ";
		
		switch(option) {
		case "도서명":
			sql += "where name like '%%"+search+"%%'";
			
			break;
		case "저자명":
			sql += "where author like '%%"+search+"%%'";
			break;
		case "출판사명":
			sql += "where publisher like '%%"+search+"%%'";
			break;
		}
		sql+="order by idx";
		
		return jt.query(sql,rowMapper);
	}

	public int regist(BookDTO dto) {
		int row = 0;
		String sql = "insert into book (name, author, publisher, publishDate, price, description) values (?, ?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdf2 = sdf.format(new Date());
		row = jt.update(sql, dto.getName(), dto.getAuthor(), dto.getPublisher(), sdf2, dto.getPrice(), dto.getDescription());
		return row;
	}
	
	
	
	

}
