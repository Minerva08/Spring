<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">


<body>
<script src="${cpath }/resources/js/script.js"></script>

	<h1>서버 프로그램 구현</h1>
	<div class="fe">응시자 : 김재령</div>
	<hr>
	<h2>
		<span class="blueFore">이번주</span> 베스트셀러
	</h2>
	<ul class="channel list">
		<li class="selected"><a href="">YES24</a></li>
		<li><a href="">인터넷 교보문고</a></li>
		<li><a href="">알라딘</a></li>
		<li><a href="">인터파크 도서</a></li>
		<li><a href="">영풍문고</a></li>
		<li><a href="">도서11번가</a></li>
		<li><a href="">커넥츠북</a></li>
	</ul>

	<ul class="category list">
		<li><a href="">종합</a></li>
		<li><a href="">소설</a></li>
		<li><a href="">시/에세이</a></li>
		<li><a href="">비즈니스와 경제</a></li>
		<li><a href="">자기관리</a></li>
		<li><a href="">어린이</a></li>
		<li class="selected"><a href="">유아</a></li>
		<li><a href="">인문</a></li>
		<li><a href="">역사와 문화</a></li>
		<li><a href="">국어와 외국어</a></li>
		<li><a href="">가정과 생활</a></li>
	</ul>

	<div class="fe small">
		<span class="bold">YES24 업데이트: </span> <span>매주 화요일, </span> <span
			class="bold">집계기간: </span> <span>2021.12.27~01.02</span>
	</div>

	<div class="result"></div>
	
	<script>
		console.log('onload')
		const cpath='${cpath}'
		const url =cpath+ '/BookList'
		const opt = {
			method: 'GET'
		}
		fetch(url, opt)
		.then(resp => resp.json())
		.then(json => {
			console.log(json)
			for(dto of json){
				const dom = getBookContent(dto)
				render(dom)
			}
			
		})
		
	</script>

</body>
</html>