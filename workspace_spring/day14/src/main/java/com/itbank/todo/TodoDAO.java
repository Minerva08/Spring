package com.itbank.todo;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDAO {

	@Select("select * from todo order by tdate")	// 일정은 날짜순으로
	List<TodoDTO> selectList();

	@Insert("insert into todo (title, content, tdate) "
			+ "values (#{title}, #{content}, #{tdate})")
	int insert(TodoDTO dto);

	@Delete("delete from todo where idx = #{idx}")
	   int delete(int idx);

}
