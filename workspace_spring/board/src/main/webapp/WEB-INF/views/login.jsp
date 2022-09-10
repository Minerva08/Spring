<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST" action="${cpath }/login"> 
	<p><input type="text" name="userid" placeholder="ID" required="required" autofocus="autofocus"></p>
	<p><input type="text" name="userpw" placeholder="PW" required="required"></p>
	<p><input type="submit" value="로그인"></p>
</form>
</body>
</html>