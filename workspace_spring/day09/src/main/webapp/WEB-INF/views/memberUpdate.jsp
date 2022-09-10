<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2 style="user-select: none;">회원 정보 수정</h2>
<div class="jcce">
<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" value="${info.userid }" readonly></p>
	<p><input type="password" name="userpw" placeholder="Password" value="${info.userpw }" required></p>
	<p><input type="text" name="username" placeholder="Name" value="${info.username }" required></p>
	<p><input type="text" name="email" placeholder="E-mail" value="${info.email }" required></p>
	<p>
		<label><input type="radio" name="gender" value="남성" ${info.gender == '남성' ? 'checked' : '' } required>남성</label>
		<label><input type="radio" name="gender" value="여성" ${info.gender == '여성' ? 'checked' : '' } required>여성</label>
	</p>
	<p><input type="submit" value="수정"></p>
</form>
</div>
</body>
</html>