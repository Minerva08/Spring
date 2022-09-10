<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>회원 정보 리스트</h2>
<br>

<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>주소</th>
		</tr>
	</thead>
<c:forEach var="dto" items="${list }">
	<tbody>
		<tr>
			<td>${dto.userid }</td>
			<td>${dto.userpw }</td>
			<td>${dto.username }</td>
			<td>${dto.email }</td>
			<td>${dto.address }</td>
		</tr>
	</tbody>
</c:forEach>
</table>


</body>
</html>