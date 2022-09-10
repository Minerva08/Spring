package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

// @Repository		
// myBatis:spring-scan 으로 찾을때는 실제 작업을 프록시 객체가 처리하므로 @Repository 안해도 됨
public interface BookDAO {

	@Select("select * from book order by idx")
	List<BookDTO> selectList();

	@Insert("insert into book values (book_seq.nextval, "
			+ "#{name}, #{author}, #{publisher}, #{publishDate}, #{price}, #{description})")
	int insert(BookDTO dto);
	
	// #{} 는 매개변수의 getter 에 접근하며, 자료형에 따라 따옴표 처리하거나 숫자이면 따옴표 붙이지 않는다
	// ${} 는 매개변수의 getter 에 접근하며, 자료형에 상관없이 따옴표 처리 및 변환 없이 그대로 맵핑한다
	// 특수한 경우를 제외하면, myBatis는 매개변수로 하나의 Object만 받는다
	// 여러 매개변수를 묶어서 전달하려면 HashMap을 사용할 수 있다
	
	@Select("select * from book where idx = #{idx}")
	BookDTO selectOne(int idx);
	
	@Update("update book set "
			+ "name = #{name}, "
			+ "author = #{author}, "
			+ "publisher = #{publisher}, "
			+ "publishDate = #{publishDate}, "
			+ "price = #{price}, "
			+ "description = #{description} "
			+ "where idx = #{idx}")
	int update(BookDTO dto);
	
	@Delete("delete book where idx = #{idx}")
	int delete(int idx);
	

	
}
