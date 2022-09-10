<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입장</title>
</head>
<body>

<h1>입장 (ws03)</h1>
<hr>
<form method="POST" action="${pageContext.request.contextPath }/login">
	<div>
		<input type="text" name="username" required autofocus>
		<input type="submit" value="입장">
	</div>
</form>

<fieldset style="margin: 20px auto; width: 70%;">
	<ul>
		<li>ws02에서 공백으로 도배하는 행위를 막았습니다</li>
		<li>브라우저 새로고침으로 인한 입장 메시지 도배를 막았습니다</li>
		<li>AJAX를 활용하여 현재 접속자의 목록을 화면 우측에 표시하게 했습니다</li>
		<li>아래는 살펴봐야 할 코드입니다</li>
		<br>
			<ol>
				<li>src/main/webapp/WEB-INF/views/main.jsp</li>
				<li>src/main/webapp/resources/css/chat.css</li>
				<li>src/main/webapp/resources/js/chat.js</li>
				<li>src/main/java/com/itbank/controller/AjaxController.java</li>
				<li>src/main/java/com/itbank/chat/ChatComponent.java</li>
			</ol>
		</li>
	</ul>
</fieldset>

</body>
</html>