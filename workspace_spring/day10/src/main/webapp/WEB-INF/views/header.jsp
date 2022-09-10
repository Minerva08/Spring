<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day10 - 이미지 갤러리</title>
<link type="text/css" 
	  rel="stylesheet" 
	  href="${cpath }/resources/css/style.css">
</head>
<body>

<script>
	const login = '${login.userid}'
	const cpath = '${cpath}'
</script>

<h1><a href="${cpath }">이미지 갤러리</a></h1>



