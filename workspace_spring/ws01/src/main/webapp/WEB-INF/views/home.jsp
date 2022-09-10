<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입장</title>
</head>
<body>

<h1>입장 (ws01)</h1>
<hr>
<form method="POST" action="${pageContext.request.contextPath }/login">
	<div>
		<input type="text" name="username" required autofocus>
		<input type="submit" value="입장">
	</div>
</form>

<fieldset style="margin: 20px auto; width: 70%;">
	<ul>
		<li>기본적인 웹소켓 구동 방식을 구현했습니다</li>
		<li>아래는 살펴봐야 할 코드입니다</li>
		<br>
			<ol>
				<li>web.xml</li>
				<li>root-context.xml</li>
				<li>src/main/java/com/itbank/chat/ChatComponent.java</li>
				<li>src/main/webapp/WEB-INF/views/main.jsp</li>
			</ol>
		</li>
	</ul>
</fieldset>

</body>
</html>