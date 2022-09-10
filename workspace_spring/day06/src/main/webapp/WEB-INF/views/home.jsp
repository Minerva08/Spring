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

<h1>로그인 가능한 Book</h1>
<hr>
<h3>DB 접속 정보 : ${test }</h3>
${cpath }
<ul>
	<li><a href="${cpath }/memberList">회원 목록</a></li>
	<li><a href="${cpath }/loginTest">로그인 테스트</a></li>
</ul>


</body>
</html>