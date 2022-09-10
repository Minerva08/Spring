<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
<style>
	#textarea {
		width: 400px;
		height: 75vh;
		padding: 10px;
		border: 2px solid black;
		overflow-y: auto;
		background-color: #d5e4ff;
		position: relative;
		margin-bottom: 10px;  
	}
	.bottom {
		display: flex;
		justify-content: space-between;
		width: 420px;
	}
	input[type="button"] {
		all: unset;
		padding: 10px;
		height: 40px;
		border: 2px solid black;
		box-sizing: border-box;
		cursor: pointer;
		background-color: #ffc;
		color: black;
		font-weight: bold;
	}
	a {
		text-decoration: none;
		color: inherit;
	}
	#send {
		width: 270px;
		padding: 10px;
		box-sizing: border-box;
	}
</style>
</head>
<body>

<%--세션에 username이 없으면 초기화면으로 이동하여 입장부터 할수있도록 처리하기 --%>
<c:if test="${empty username }">
	<c:redirect url="/" />
</c:if>

<h1>채팅</h1>
<div>현재 사용자 : ${username }</div>
<hr>

<div id="textarea"></div>
<div class="bottom">
	<input id="send" name="send" autofocus>
	<input id="btn" type="button" value="전송">
	<a href="${cpath }/logout"><input type="button" value="나가기"></a>
</div>

<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script>
	const username = '${username}'
	const btn = document.getElementById('btn')
	const send = document.getElementById('send')
	const textarea = document.getElementById('textarea')
	const ws = new SockJS('${cpath}/chat')	// 스프링에서 지정한 주소에 대한 컴포넌트를 작성해야 한다
	console.log(ws)
	ws.onmessage = onMessage
	ws.onopen = function(msg) {}
	ws.onclose = function(msg) {}
	ws.onerror = function(msg) {}
	
	btn.onclick = sendHandler		// 버튼을 클릭하면 보내는 함수를 호출한다
	send.onkeydown = keyHandler		// 엔터버튼 누르면 보내는 함수로 연결한다
	
	
	// 웹소켓 내부에서 사용할 함수를 정의하는 영역
	function onMessage(event) {	// 메시지를 받으면 수행하는 자바스크립트 함수
		const wrap = document.createElement('div')
		const name = document.createElement('div')
		const message = document.createElement('span')
		
		name.innerText = JSON.parse(event.data).username
		message.innerText = JSON.parse(event.data).message
		
		wrap.appendChild(name)
		wrap.appendChild(message)
		
		textarea.appendChild(wrap)
		textarea.scroll({top: textarea.scrollHeight, behavior: 'smooth'})
		// 메시지를 받으면 높이만큼 계산해서 부드럽게 스크롤 이동시키기
	}
	
	function keyHandler(event) {
		if(event.key == 'Enter') {
			sendHandler(event)
		}
	}
	
	function sendHandler(event) {	// 메시지를 보내는 자바스크립트 함수
		const message = send.value
		send.value = ''
		ws.send(JSON.stringify({
			username: username,
			message: message
		}))
		send.focus()
	}
	
</script>

</body>
</html>