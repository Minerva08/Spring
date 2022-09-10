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
<form method="POST" action="${cpath }/book/regist2">
	<input type="text" name="name" placeholder="도서명" required="required">
	<input type="text" name="author" placeholder="저자" required="required">
	<input type="text" name="publisher" placeholder="출판사" required="required">
	<input type="date" name="publishDate" placeholder="출판일자" required="required">
	<input type="number" name="price" placeholder="가격" required="required" step="1000">
	<input type="text" name="description" placeholder="책 소개" required="required">
	<input type="submit" value="등록">
</form>
</body>
</html>