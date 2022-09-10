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
<h1>정적파일 서버 연동하기</h1>
<hr>

<form method="POST" action="${cpath }/upload" enctype="multipart/form-data">
	<input type="file" name="uploadFile">
	<input type="submit">
</form>

</body>
</html>