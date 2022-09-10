package com.itbank.model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itbank.service.Paging;

@Repository
public class BookDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	private RowMapper<BookDTO> rowMapper = (ResultSet rs, int rownum) -> {
		BookDTO ob = new BookDTO();
		ob.setIdx(rs.getInt("idx"));
		ob.setPrice(rs.getInt("price"));
		ob.setName(rs.getString("name"));
		ob.setAuthor(rs.getString("author"));
		ob.setPublisher(rs.getString("publisher"));
		ob.setDescription(rs.getString("description"));
		ob.setPublishdate(rs.getDate("publishdate"));
		return ob;
	};

	public List<BookDTO> list() {
		String sql = "select * from book order by idx";
		List<BookDTO> list = jt.query(sql, rowMapper);
		return list;
	}

	public int insert(BookDTO dto) {
		int row = 0;
		String sql = "insert into book (name, author, publisher, publishDate, price, description) values (?, ?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdf2 = sdf.format(new Date());
		row = jt.update(sql, dto.getName(), dto.getAuthor(), dto.getPublisher(), sdf2, dto.getPrice(), dto.getDescription());
		return row;
	}

	public List<BookDTO> searchlist(String choice, String search) {
		String sql = "select * from book where " + choice + " like " + "'%%" + search + "%%'";
		return jt.query(sql, rowMapper);
	}

	public int delete(int idx) {
		String sql = "delete book where idx=" + idx;
		return jt.update(sql);
	}

	public int modify(BookDTO dto, int idx) {
		String sql = "update book set name=?, author=?, publisher=?, publishdate=?, price=?, description=? where idx=" + idx;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdf2 = sdf.format(new Date());
		return jt.update(sql, dto.getName(), dto.getAuthor(), dto.getPublisher(), sdf2, dto.getPrice(), dto.getDescription());
	}

	public Paging paging(int nowpage) {
		// TODO Auto-generated method stub
		return null;
	}

	public int pageCount() {
		String sql = "select count(*) as pageCount from book";
		RowMapper<Integer> rowMapper = (ResultSet rs, int rownum) -> {
			int pagecount = rs.getInt("pagecount");
			return pagecount;
		};
		return jt.queryForObject(sql, rowMapper);
	}
	
	
	
	
	
	
	
	
	
	
	
}
