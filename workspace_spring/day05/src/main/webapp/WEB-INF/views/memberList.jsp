<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>회원 목록</h1>
<hr>
<h3>${test }</h3>
<h3>${now }</h3>

<%-- list 확인 : ${list } --%>
<table border="1" cellpadding="7" cellspacing="0">
	<tr>
		<th>userid</th>
		<th>userpw</th>
		<th>username</th>
		<th>email</th>
		<th>gender</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.userid }</td>
		<td>${dto.userpw }</td>
		<td>${dto.username }</td>
		<td>${dto.email }</td>
		<td>${dto.gender }</td>
	</tr>
	</c:forEach>
</table>


</body>
</html>