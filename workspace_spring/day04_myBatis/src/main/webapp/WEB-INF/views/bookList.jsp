<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>도서 목록</h3>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>출판일자</th>
			<th>가격</th>
			<th>설명</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td>${dto.name }</td>
			<td>${dto.author }</td>
			<td>${dto.publisher }</td>
			<td>${dto.publishDate }</td>
			<td>${dto.price }</td>
			<td>${dto.description }</td>
			<td><a href="${cpath }/update/${dto.idx}"><button>수정</button></a></td>
			<td><button class="deleteBtn" data-idx="${dto.idx }">삭제</button></td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	const cpath = '${cpath}'

	document.querySelectorAll('.deleteBtn').forEach(function(btn) {
		btn.onclick = function(event) {
			const idx = event.target.dataset.idx
			if(confirm('정말 ' + idx + '번 도서를 삭제하시겠습니까?')) {
				location.href = cpath + '/delete/' + idx
			}
		}
	})
</script>

</body>
</html>