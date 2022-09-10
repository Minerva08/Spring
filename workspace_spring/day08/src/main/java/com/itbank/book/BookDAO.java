package com.itbank.book;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface BookDAO {

	List<BookDTO> selectList(HashMap<String, String> map);

	@Delete("delete book where idx=#{idx}")
	int delete(int idx);

	@Select("select * from book where idx=#{idx}")
	BookDTO select(int idx);

	int update(BookDTO dto);

	int insert(BookDTO dto);

}







