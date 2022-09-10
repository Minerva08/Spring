<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>day03 홈 컨트롤러</h1>
	<hr>
	<ul>
		<li><a href="${cpath }/book/list">북 목록</a></li>
		<li><a href="${cpath }/book/insert">북 추가</a></li>
		<li><a href="${cpath }/book/searchlist">북 검색</a></li>
		
		<c:if test="${empty login }">
			<li><a href="${cpath }/member/login">관리자 로그인</a></li>
		</c:if>
		<c:if test="${not empty login }">
			<li><a href="${cpath }/member/logout">${login.userid }님 계정 로그아웃</a></li>
		</c:if>
	</ul>
</body>
</html>