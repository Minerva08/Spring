<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
		text-align: center;
	}
	table {
		width: 100%;
	}
	table, tr > th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>day03/book/searchlist 북 검색</h1>
	<hr>
	<form method="POST">
		<select name="choice">
			<option value="name">제목</option>
			<option value="author">저자</option>
			<option value="description">내용</option>
		</select>
		<input type="text" name="search" placeholder="검색어 입력" required="required" autofocus="autofocus">
		<input type="submit" value="검색">
	</form>
	
	<table>
		<tr>
			<th>idx</th>
			<th>북제목</th>
			<th>글쓴이</th>
			<th>출판사</th>
			<th>출판날짜</th>
			<th>가격</th>
			<th>내용</th>
			<th>관리</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td>${dto.name }</td>
				<td>${dto.author }</td>
				<td>${dto.publisher }</td>
				<td>${dto.publishdate }</td>
				<td>${dto.price }</td>
				<td>${dto.description }</td>
				<td>
					<a href="${cpath }/book/modify?idx=${dto.idx}&login=${login.userid}"><button>수정</button></a>
					<a href="${cpath }/book/searchdelete?idx=${dto.idx}&login=${login.userid}&choice=${choice}&search=${search}"><button>삭제</button></a>				
				</td>
			</tr>
		</c:forEach>
		</table>

	<a href="${cpath }/"><button>홈 컨트롤러 가기</button></a>
</body>
</html>