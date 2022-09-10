<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<form method="POST">
		<select name="option">
			<option>도서명</option>
			<option>저자명</option>
			<option>출판사</option>
		</select>
		
		<input type="text" name="search">
		<button>검색</button>
	</form>
</div>

<table >
	<tr>
		<td>번호</td>
		<td>도서명</td>
		<td>저자명</td>
		<td>출판사</td>
		<td>출판일자</td>
		<td>가격</td>
		<td>줄거리</td>
	</tr>
	<c:forEach var="booklist" items="${list}">
		<tr>
			<td>${booklist.idx }</td>
			<td>${booklist.name }</td>
			<td>${booklist.author }</td>
			<td>${booklist.publisher }</td>
			<td>${booklist.pulishdate }</td>
			<td>${booklist.price }</td>
			<td>${booklist.description }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>