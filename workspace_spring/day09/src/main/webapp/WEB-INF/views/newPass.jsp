<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>비밀번호 재발급</h2>

<div class="jcce">
	<h4>비밀번호를 재발급할 계정의 ID와 Email을 입력하여 인증을 진행해주세요</h4>
</div>

<div class="jcce">
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
		<p><input type="email" name="email" placeholder="foo@bar.com" required></p>
		<p><input class="btn" type="submit" value="재발급신청"></p>
	</form>
</div>

</body>
</html>