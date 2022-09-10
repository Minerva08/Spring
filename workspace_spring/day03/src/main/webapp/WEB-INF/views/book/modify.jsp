<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>day03/book/modify 북 수정</h1>
	<hr>
	
	<form method="POST">		
		<p><input type="hidden" name="choice" value="${choice }">
		<p><input type="hidden" name="search" value="${search }">
		<p><input type="hidden" name="idx" value="${param.idx }">
		<p><input type="text" name="name" placeholder="북 제목" required="required"></p>
		<p><input type="text" name="author" placeholder="글쓴이" required="required"></p>
		<p><input type="text" name="publisher" placeholder="출판사" required="required"></p>
		<p><input type="number" name="price" placeholder="가격" required="required"></p>
		<p>
			<textarea style='width: 300px; height: 100px;' name="description" placeholder="내용을 입력하세요" required="required"></textarea>
		</p>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>