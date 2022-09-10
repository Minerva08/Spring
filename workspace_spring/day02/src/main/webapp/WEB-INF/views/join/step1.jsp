<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>step1 : 회원 가입 약관 동의</h1>
<hr>

<form action="${cpath }/join/step2">
	<textarea style="width: 800px; height: 400px; resize: none;" readonly>${agreement }</textarea>
	<p>
		<label>
			<input type="checkbox" name="agree">위 사항을 읽었으며, 약관에 동의합니다
		</label>
	</p>
	<input type="submit" value="다음">
</form>

</body>
</html>