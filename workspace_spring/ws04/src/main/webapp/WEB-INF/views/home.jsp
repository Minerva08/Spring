<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입장</title>
</head>
<body>

<h1>입장 (ws04)</h1>
<hr>
<form method="POST" action="${pageContext.request.contextPath }/login">
	<div>
		<input type="text" name="username" required autofocus>
		<input type="submit" value="입장">
	</div>
</form>

<fieldset style="margin: 20px auto; width: 70%;">
	<ul>
		<li>ws03에서 사용자 목록을 숨김처리하고 버튼을 통해 확인하도록 변경했습니다</li>
		<li>기본 레이아웃이 약간 변경되었습니다</li>
		<li>짧은 시간내에 입장/퇴장이 발생하면 메시지를 출력하지 않도록 처리했습니다</li>
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