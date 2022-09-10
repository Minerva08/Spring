package com.itbank.member;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {
	@Select("select * from member where userid=#{userid}")
	MemberDTO selectMember(String userid);
	
	@Select("select * from member order by userid")
	List<MemberDTO> getMemberList();

	@Select("select * from member where username like '%${username}%' order by username")
	List<MemberDTO> getMemberListByUsername(String username);
	
	@Insert("insert into member values(#{userid},#{userpw},#{username},#{email},#{gender})")
	int joinmember(MemberDTO dto);

	
	
}
