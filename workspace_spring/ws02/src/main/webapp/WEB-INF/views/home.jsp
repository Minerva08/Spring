<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입장</title>
</head>
<body>

<h1>입장 (ws02)</h1>
<hr>
<form method="POST" action="${pageContext.request.contextPath }/login">
	<div>
		<input type="text" name="username" required autofocus>
		<input type="submit" value="입장">
	</div>
</form>

<fieldset style="margin: 20px auto; width: 70%;">
	<ul>
		<li>ws01에서 css와 js를 분리하여 추가했습니다</li>
		<li>메시지를 보낸 사람에 따라서 화면에 나타나는 형태를 달리 했습니다</li>
		<li>아래는 살펴봐야 할 코드입니다</li>
		<br>
			<ol>
				<li>src/main/webapp/WEB-INF/views/main.jsp</li>
				<li>src/main/webapp/resources/css/chat.css</li>
				<li>src/main/webapp/resources/js/chat.js</li>
				<li>src/main/java/com/itbank/chat/ChatComponent.java</li>
			</ol>
		</li>
	</ul>
</fieldset>

</body>
</html>