package com.itbank.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO {

	@Select("select idx, writer, content, to_char(writeDate,'yyyy-MM-dd') as writeDate from board2" + 
			"    order by idx desc" + 
			"    OFFSET #{offset} ROWS " + 
			"    FETCH NEXT 5 ROWS ONLY")
	List<HashMap<String, Object>> selectBoardData(int offset);

	@Insert("insert into board2 (title, writer, content, ipaddress) values "
			+ "( #{title}, #{writer}, #{content}, #{ipaddr} )")
	int insertBoardData(HashMap<String, String> map);

}
