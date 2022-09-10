<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>회원 가입</h2>
<!-- 
		회원 가입 코드를 직접 구현하고, myBatis에서는 xml을 활용하여 처리해보세요
		가입을 처리한 이후 로그인 페이지로 리다이렉트 하세요
 -->
<div class="jcce">
<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="text" name="username" placeholder="Name" required></p>
	<p><input type="text" name="email" placeholder="E-mail" required></p>
	<p>
		<label><input type="radio" name="gender" value="남성" required>남성</label>
		<label><input type="radio" name="gender" value="여성" required>여성</label>
	</p>
	<p><input type="submit" value="가입"></p>
</form>
</div>

</body>
</html>