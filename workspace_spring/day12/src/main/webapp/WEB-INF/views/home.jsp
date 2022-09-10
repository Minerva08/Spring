<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<ul>
	<li><a href="${cpath }/ex01">ex01-기본 GET요청</a></li>
	<li><a href="${cpath }/ex02">ex02-GET-GET파라미터 전달</a></li>
	<li><a href="${cpath }/ex03">ex03-GET-userid를 이용한 객체 불러오기</a></li>
	<li><a href="${cpath }/ex04">ex04-GET-전체 목록을 AJAX로 불러오기</a></li>
	<li><a href="${cpath }/quiz">quiz-GET-사용자 이름으로 검색하여 목록 불러오기</a></li>
	<li><a href="${cpath }/quiz2">quiz-GET-회원가입페이지</a></li>
	<!--
		일반적인 jsp를 만들어 화면 출력
		회원가입시 id입력란 옆에 중복확인 버튼을 만들고
		중복확인을 누르면 DB에 일치하는 계정이 있는지 없는지 확인하여
		alert로 메세지를 띄웁니다
		사용할 수 없는 아이디라면 다시 id입력란에 글자를 선택
		사용가능하다면 다음 input으로 포커스를 이동시킵니다 
	-->
</ul>
</body>
</html>