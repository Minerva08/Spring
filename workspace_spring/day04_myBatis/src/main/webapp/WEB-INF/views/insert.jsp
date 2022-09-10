<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>도서 추가</h3>

<form method="POST">
	<p><input type="text" name="name" required autofocus placeholder="도서명"></p>
	<p><input type="text" name="author" required placeholder="저자"></p>
	<p><input type="text" name="publisher" required placeholder="출판사"></p>
	<p><input type="date" name="publishDate" required></p>
	<p><input type="number" name="price" required placeholder="가격" step="100"></p>
	<p><input type="text" name="description" required placeholder="도서 소개글"></p>
	<p><input type="submit"></p>
</form>

</body>
</html>