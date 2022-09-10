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
	<h1>day03/book/list 북 리스트</h1>
	<hr>
	
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
					<a href="${cpath }/book/delete?idx=${dto.idx}&login=${login.userid}"><button>삭제</button></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${cpath }/"><button>홈 컨트롤러 가기</button></a>
	<div>
		<c:if test=""><div><a>[이전]</a></div></c:if>
		<c:forEach var="page" items="${pagelist }" begin="" end="">
			<div><a></a></div>
		</c:forEach>
		<c:if test=""><div><a>[다음]</a></div></c:if>
	</div>
</body>
</html>