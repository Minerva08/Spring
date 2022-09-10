<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload2.jsp</title>
</head>
<body>

<h1>스프링 파일 업로드 (2)</h1>
<hr>
<form method="POST" enctype="multipart/form-data">
	<p><input name="name" placeholder="이름"></p>
	<p><input name="age" type="number" placeholder="나이"></p>
	<p><input type="file" name="uploadFile"></p>
	<p><input type="submit" value="전송"></p>
</form>

<div style="display: flex; 
			flex-flow: wrap; 
			width: 800px; 
			border: 2px solid black; 
			padding: 20px;">
	<c:forEach var="dto" items="${list }">
	<div style="border: 1px solid blue; 
				padding: 10px;
				margin-right: 10px;">
		<div class="name">${dto.name }</div>
		<div class="age">${dto.age }살</div>
		<div class="img">
			<img src="${cpath }/upload/${dto.fileName }" width="200px">
		</div>
	</div>
	</c:forEach>
</div>

<a href="/day09_file">대문 페이지로 돌아가기</a>


</body>
</html>