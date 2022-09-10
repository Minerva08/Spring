package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO {

	@Select("select * from booklist")
	List<BookDTO> selectList();

}
