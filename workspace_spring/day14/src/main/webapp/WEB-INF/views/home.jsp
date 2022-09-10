<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Simple Todo List</title>
<link rel="stylesheet" type="text/css" href="${cpath }/resources/css/style.css">
</head>
<script>
	const cpath = '${cpath}'
</script>
<script src="${cpath }/resources/js/function.js"></script>
<body>
<header>
	<h1><a href="${cpath }">Simple TodoList</a></h1>
</header>
<section id="form">
	<form>
		<p><input name="title" placeholder="제목" required autofocus></p>
		<p><input name="content" placeholder="내용" required></p>
		<p><input type="date" name="tdate"></p>
		<p><input type="submit"></p>
	</form>
</section>
<section id="list"></section>
<%--
		폼에 입력된 데이터를 서버에 제출하여 DB에 추가하고
		list.innerHTML = ''
		새로고침 없이 목록을 갱신하기
 --%>

<script>
	// 자바스크립트 이벤트 처리
// 	window.onload = loadHandler
	
	const form = document.querySelector('#form > form')
	const list = document.getElementById('list')
	window.onload = async function() {
		await loadHandler()
		const item = document.querySelector('.item')
		console.log(item)
	 	item.oncontextmenu = rightClickHandler
	}
	
	
	form.onsubmit = submitHandler
	//document.querySelectorAll('.item').forEach(item => item.oncontextmenu = rightClickHandler)
</script>
</body>
</html>