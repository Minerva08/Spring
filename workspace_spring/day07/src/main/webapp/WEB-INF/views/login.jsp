<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>로그인</h2>
<hr>
<form method="POST" class="ffc aice jcfs">
	<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="submit"></p>
</form>

<div class="jcce">
	<a href="${cpath }/join">아직 회원이 아니십니까?</a>&nbsp; &nbsp;
	<a href="${cpath }/newPass">비밀번호를 분실했습니다</a>
</div>

</body>
</html>