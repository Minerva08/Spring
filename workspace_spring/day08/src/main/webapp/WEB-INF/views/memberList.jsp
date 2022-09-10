<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>회원 목록</h2>
<hr>

<table border="1" cellpadding="7" cellspacing="0">
	<tr>
		<th>userid</th>
		<th>userpw</th>
		<th>username</th>
		<th>email</th>
		<th>gender</th>
	</tr>
	<c:forEach var="member" items="${list }">
	<tr>
		<td>${member.userid }</td>
		<td>${member.userpw }</td>
		<td>${member.username }</td>
		<td>${member.email }</td>
		<td>${member.gender }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>