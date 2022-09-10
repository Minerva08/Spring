<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>jdbcTemplate 테스트</h1>
<hr>
<h3>${msg }</h3>

<ul>
	<li><a href="${cpath }/join">회원가입 예제</a></li>
	<li><a href="${cpath }/list">회원목록 확인</a></li>
</ul>

</body>
</html>