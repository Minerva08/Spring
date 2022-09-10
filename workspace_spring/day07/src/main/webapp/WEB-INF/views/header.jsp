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
	body {
		width: 100%;
		overflow-x: hidden;
	}
	div, span, header, nav, main, section, article, footer, aside {
		box-sizing: border-box;
	}
	a {
		text-decoration: none;
		color: inherit;
	}
	a:hover {
		text-decoration: underline;
	}
	.btn {
		display: block;
		min-width: 120px; height: 40px; line-height: 40px; text-align: center;
		background-color: darkgrey;
		color: black;
		font-size: 14px;
		font-weight: bold;
		transition-duration: 0.5s;
		border: 0;
		margin: auto;
	}
	.btn:hover {
		text-decoration: none;
		background-color: black;
		color: white;
		transition-duration: 0.5s;
	}
	.ffc, .ffw, .ffr, .jcfs, .jcce, .jcfe, .jcsb, .aifs, .aice, .aife {
		display: flex;
	}
	.ffc { flex-flow: column;}
	.ffw { flex-flow: wrap;}
	.ffr { flex-flow: row;}
	.jcfs { justify-content: flex-start;}
	.jcce { justify-content: center;}
	.jcfe { justify-content: flex-end;}
	.jcsb { justify-content: space-between;}
	.aifs { align-items: flex-start;}
	.aice { align-items: center;}
	.aife { align-items: flex-end;}
	nav > ul {
		padding: 0;
		width: 800px;
		margin: auto;
		list-style: none;
	}
	h1 {
		text-align: center;
	}
	table th {
		padding: 0;
	}
</style>
</head>
<body>
<header>
	<h1><a href="${cpath }">day07</a></h1>
	<div class="jcfe" style="padding-right: 20px; height: 20px;">
		<c:if test="${not empty login }">
		<a href="${cpath }/memberInfo">${login.userid } (${login.username })</a>
		</c:if>
	</div>
	<nav>
		<ul class="ffr jcce">
			<c:if test="${empty login }">
				<li><a class="btn" href="${cpath }/login">로그인</a></li>
			</c:if>
			<c:if test="${not empty login }">
				<li><a class="btn" href="${cpath }/logout">로그아웃</a></li>
			</c:if>
			<li><a class="btn" href="${cpath }/bookList">도서 관리</a></li>
		</ul>
	</nav>
</header>
