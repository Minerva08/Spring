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
<h1>컨트롤러 예제</h1>
<hr>

<ul>
	<li><a href="${pageContext.request.contextPath }/ex01">ex01-링크를 클릭하면 연결되는 함수</a></li>
	<li><a href="${cpath }/ex02">ex02-링크를 클릭하면 연결되는 함수</a></li>
	<li><a href="${cpath }/ex03">ex03-커맨드 객체</a></li>
	<li><a href="${cpath }/ex04">ex04-Model And View</a></li>
	<li><a href="${cpath }/ex05">ex05-Path Variable</a></li>
	<li><a href="${cpath }/calc">calc-두수의 사칙 연산 계산기</a></li>
</ul>
</body>
</html>