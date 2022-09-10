<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>채팅</title>
<link rel="stylesheet" href="${cpath }/resources/css/chat.css">
<link rel="stylesheet" href="${cpath }/resources/css/chatToTarget.css">
</head>
<%--JSP의 요소를 자바스크립트의 변수로 선언해서 다른 .js파일에서 사용할 수 있도록 만들기 --%>
<script>
	const username = '${username}'
	const cpath = '${cpath}'
</script>
<body>

<%--세션에 username이 없으면 초기화면으로 이동하여 입장부터 할수있도록 처리하기 --%>
<c:if test="${empty username }">
	<c:redirect url="/" />
</c:if>

<h1>채팅</h1>
<div>현재 사용자 : ${username }</div>
<hr>

<div class="main">
	<div class="wrap">
		<div class="left">
			<div id="textarea" class="textarea">
				<div class="overlay hidden"></div>
			</div>
		</div>
		<div class="right">
			<div id="hamburger">≡</div>
			<div class="aside">
				<h4>사용자 목록</h4>
				<div class="userList"></div>
			</div>	
		</div>
	</div>
	<div class="bottom">
		<input id="send" class="send" name="send" autofocus>
		<input id="btn" class="btn" type="button" value="전송">
		<input id="quit" class="quit" type="button" value="나가기">
	</div>
</div>

<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script src="${cpath }/resources/js/chat.js"></script>
<script src="${cpath }/resources/js/chatToTarget.js"></script>

</body>
</html>