<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>도서 추가</h2>

<form method="POST">
	<p><input type="text" name="name" placeholder="도서명" required autofocus></p>
	<p><input type="text" name="author" placeholder="저자명" required></p>
	<p><input type="text" name="publisher" placeholder="출판사" required></p>
	<p><input type="date" name="publishDate" required></p>
	<p><input type="number" step="100" name="price" placeholder="가격" required></p>
	<p>
		<textarea name="description" placeholder="도서 설명" required></textarea>
	</p>
	<p><input type="submit" value="추가"></p>
</form>	

<script>
	const today = new Date().toISOString().split('T')[0]
	console.log(today)
	
	document.querySelector('input[type="date"]').value = today
</script>

</body>
</html>