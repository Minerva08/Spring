<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>도서 정보 수정 : ${dto.idx }번 도서</h2>

<form method="POST">
	<p><input type="text" name="name" value="${dto.name }" required autofocus></p>
	<p><input type="text" name="author" value="${dto.author }" required></p>
	<p><input type="text" name="publisher" value="${dto.publisher }" required></p>
	<p><input type="date" name="publishDate" value="${dto.publishDate }" required></p>
	<p><input type="number" step="100" name="price" value="${dto.price }" required></p>
	<p>
		<textarea name="description" required>${dto.description }</textarea>
	</p>
	<p><input type="submit" value="수정"></p>
</form>	

</body>
</html>