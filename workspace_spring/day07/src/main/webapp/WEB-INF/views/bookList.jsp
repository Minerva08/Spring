<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>도서 목록</h2>

<div style="margin: 20px 0;">
	<form>
		<select name="column">
			<option value="idx">도서 번호로 검색</option>
			<option value="name">도서명으로 검색</option>
			<option value="author">저자명으로 검색</option>
		</select>
		<input type="search" name="word" placeholder="검색어를 입력하세요">
		<input type="submit" value="검색">
	</form>
</div>

<table border="1" cellpadding="7" cellspacing="0">
	<tr>
		<th><a class="btn" href="${cpath }/bookList/idx">IDX</a></th>
		<th><a class="btn" href="${cpath }/bookList/name">NAME</a></th>
		<th><a class="btn" href="${cpath }/bookList/author">AUTHOR</a></th>
		<th><a class="btn" href="${cpath }/bookList/publisher">PUBLISHER</a></th>
		<th><a class="btn" href="${cpath }/bookList/publishDate">PUBLISHDATE</a></th>
		<th><a class="btn" href="${cpath }/bookList/price">PRICE</a></th>
		<th><a class="btn" href="${cpath }/bookList/description">DESCRIPTION</a></th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.idx }</td>
		<td>${dto.name }</td>
		<td>${dto.author }</td>
		<td>${dto.publisher }</td>
		<td>${dto.publishDate }</td>
		<td>${dto.price }</td>
		<td>${dto.description }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>