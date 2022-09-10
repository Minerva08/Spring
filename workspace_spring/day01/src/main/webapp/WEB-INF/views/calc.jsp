<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>두수의 사칙연산 계산기</h1>

<form method="POST">
	<input type="number" name="n1" style="width:50px;" placeholder="수" required="required">
	
	<select name="op">
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
	</select>
	
	<input type="number" name="n2" style="width:50px;" placeholder="수" required="required">
	<input type="submit" value="계산"> 
</form>

<h3>${dto.n1}  ${dto.op}  ${dto.n2 }  =  ${dto.result }</h3>

</body>
</html>