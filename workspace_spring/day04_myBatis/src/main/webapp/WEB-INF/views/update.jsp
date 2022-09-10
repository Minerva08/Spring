<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>도서 수정</h3>

<form method="POST">
	<p><input type="text" name="name" required autofocus value="${dto.name }"></p>
	<p><input type="text" name="author" required value="${dto.author }"></p>
	<p><input type="text" name="publisher" required value="${dto.publisher }"></p>
	<p><input type="date" name="publishDate" required value="${dto.publishDate }"></p>
	<p><input type="number" name="price" required value="${dto.price }" step="100"></p>
	<p><input type="text" name="description" required value="${dto.description }"></p>
	<p><input type="submit" value="수정"></p>
</form>

</body>
</html>