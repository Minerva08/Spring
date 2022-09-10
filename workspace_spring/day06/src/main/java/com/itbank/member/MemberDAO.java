package com.itbank.member;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface MemberDAO {

	@Select("select * from member order by userid")
	List<MemberDTO> selectList();

	// 어노테이션 대신 XML 설정으로 쿼리문 수행하기
	// namespace 는 패키지.인터페이스이름
	// id는 메서드이름
	
	// <mapper namespace="com.itbank.member.MemberDAO">
	//		<select id="selectMembmer" resultType="com.itbank.member.MemberDTO">
	//			select * from member where userid = #{userid} and userpw = #{userpw}
	//		</select>
	// </mapper>
	MemberDTO selectMember(MemberDTO dto);

}
