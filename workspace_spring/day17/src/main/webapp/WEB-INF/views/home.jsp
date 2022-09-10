<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공공 데이터 포털 코로나 시도 발생현황</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css"> 
</head>
<body>
<script src="${cpath }/resources/js/xml2json.js"></script>
<script src="${cpath }/resources/js/function.js"></script>

<h1>공공 데이터 포털 코로나 시도 발생현황</h1>
<hr>

<div id="root"></div>

<script>
	const root = document.getElementById('root')
	const cpath = '${cpath}'
	
	window.onload = getCovidDataJava		// 스프링 서버로 데이터 받아오기

</script> 



</body>
</html>