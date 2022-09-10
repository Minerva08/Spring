<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<hr>
<h2>로그인 페이지</h2>

<form id="loginForm" method="POST" action="${cpath }/login">
	<p><input type="text" name="userid" placeholder="ID"></p>
	<p><input type="password" name="userpw" placeholder="Password"></p>
	<p><input type="submit" value="로그인"></p>
</form>

</body>
</html>