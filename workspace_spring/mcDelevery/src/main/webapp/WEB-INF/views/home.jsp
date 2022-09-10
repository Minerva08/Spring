<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">
</head>
<body>
<script src="${cpath }/resources/js/mcDelivery.js"></script>
<script>
	const cpath = '${cpath}'
</script>


<header>
	<div class="sb">
		<div>한국어 | English</div>
		<div>ㅇ | 로그인 | 주문조회 | 응시자 : ㅇㅇㅇ</div>
	</div>
	<nav>
		<ul>
			<li>McDelivery</li>
			<li>메뉴</li>
			<li>마이 페이지</li>
			<li>기타정보</li>
		</ul>
	</nav>
</header>
<div class="sb">
	<aside>
		<ul>
			<li>아침메뉴</li>
			<li>● 추천메뉴</li>
			<li>● 맥모닝 & 세트</li>
			<li>● 스낵 & 사이드</li>
			<li>● 음료</li>
			<li>● 디저트</li>
			<li>● 해피밀®</li>
			<li>● 일반메뉴</li>
		</ul>
	</aside>
	<div id="result"></div>
</div>

<script>
	const result = document.getElementById('result')
	render(result)
</script>

</body>
</html>