package com.itbank.todo;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface TodoDAO {
	
	@Select("select * from todo")
	List<TodoDTO> getList();

}
