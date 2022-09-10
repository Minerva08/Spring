package com.itbank.model;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {

	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login(MemberDTO dto);
	

}
