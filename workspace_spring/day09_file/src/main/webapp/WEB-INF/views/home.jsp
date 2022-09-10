<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>

<h1>스프링 파일 업로드</h1>
<hr>
<form method="POST" enctype="multipart/form-data">
	<p><input type="file" name="file"></p>
	<p><input type="submit" value="전송"></p>
</form>

<a href="/day09_file/upload2">파일을 포함한 여러 파라미터 전송</a>


</body>
</html>