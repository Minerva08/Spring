package com.itbank.member;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
	
	@Select("select * from member2 where userid='${userid}' and userpw='${userpw}'")
	Memberdto selectOne(Memberdto dto);

	@Select("select * from member2")
	List<Memberdto> selectAll();

	@Insert("insert into member2 values('${userid}', '${userpw}', '${username}', '${email}', '${address}')")
	int insert(Memberdto dto);
}
//	int insert(HashMap<String, String> map);
