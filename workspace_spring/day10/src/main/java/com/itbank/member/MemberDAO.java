package com.itbank.member;

import org.apache.ibatis.annotations.Select;

public interface MemberDAO {

	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO selectMember(MemberDTO dto);

}
