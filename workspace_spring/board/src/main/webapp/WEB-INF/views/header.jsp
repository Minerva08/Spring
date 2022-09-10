<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{
		text-align: center;
	}
	nav{
		display: flex;
		width:500px;
		margin: 10px auto;
	}
	div{
		width: 100px;
		text-align: center;
		margin:10px;
	}
	h4{
		text-align: right;
	}
</style>
</head>
<body>

<script>
	const cpath = '${cpath}'
</script>
<header>
	<h1><a href="${cpath }">practice</a></h1>
	<h4>${login.userid }</h4>
	<hr>
	
	<nav>
		<div><a href="${cpath }/board">게시판</a></div>
		<div><a href="${cpath }/login">로그인</a></div>
		<div><a href="${cpath }/upload">파일 업로드</a></div>
		<div><a href="${cpath }/join">회원가입</a></div>
	</nav>
	
</header>

