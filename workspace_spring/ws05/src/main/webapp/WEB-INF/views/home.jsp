<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입장</title>
</head>
<body>

<h1>입장 (ws05)</h1>
<hr>
<form method="POST" action="${pageContext.request.contextPath }/login">
	<div>
		<input type="text" name="username" required autofocus>
		<input type="submit" value="입장">
	</div>
</form>

<fieldset style="margin: 20px auto; width: 70%;">
	<ul>
		<li>ws04에서 1:1 채팅 기능을 추가하였습니다(진행중)</li>
		<li>1:1 채팅창은 모달형식이며, 드래그하여 위치를 이동할 수 있습니다</li>
		<li>1:1 채팅창은 닫기 한 이후 상대로부터 대화가 들어오면 다시 활성화됩니다</li>
		<li>아래는 살펴봐야 할 코드입니다</li>
		<br>
			<ol>
				<li>src/main/webapp/resources/js/chat.js</li>
				<li>src/main/webapp/resources/css/chatToTarget.css</li>
				<li>src/main/webapp/resources/js/chatToTarget.js</li>
				<li>src/main/java/com/itbank/chat/ChatComponent.java</li>
			</ol>
		</li>
	</ul>
</fieldset>

</body>
</html>