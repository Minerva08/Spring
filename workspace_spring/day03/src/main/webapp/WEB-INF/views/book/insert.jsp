<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>day03/book/insert 북 추가</h1>
	<hr>
	<form method="POST">
		<p><input type="text" name="name" placeholder="북 제목" required="required"></p>
		<p><input type="text" name="author" placeholder="글쓴이" required="required"></p>
		<p><input type="text" name="publisher" placeholder="출판사" required="required"></p>
		<p><input type="number" name="price" placeholder="가격" required="required"></p>
		<p>
			<textarea style='width: 300px; height: 100px;' name="description" placeholder="내용을 입력하세요" required="required"></textarea>
		</p>
		<input type="submit" value="추가하기">
	</form>
	<a href="${cpath }/"><button>홈 컨트롤러 가기</button></a>
</body>
</html>