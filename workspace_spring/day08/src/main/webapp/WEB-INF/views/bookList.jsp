<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>도서 목록</h2>

<div class="jcsb" style="margin: 20px 0; max-width: 1550px;">
	<div>
		<form>
			<select name="column">
				<option value="idx" ${param.column eq 'idx' ? 'selected' : '' }>도서 번호로 검색</option>
				<option value="name" ${param.column eq 'name' ? 'selected' : '' }>도서명으로 검색</option>
				<option value="author" ${param.column eq 'author' ? 'selected' : '' }>저자명으로 검색</option>
			</select>
			<input type="search" name="search" placeholder="검색어를 입력하세요" value="${param.search }">
			<input type="submit" value="검색">
		</form>
	</div>
	
	<div style="margin: 0 10px;">
		<a href="${cpath }/addBook"><button>추가</button></a>
	</div>
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
		<th>수정</th>
		<th>삭제</th>
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
		<td><button class="modifyBtn" data-idx="${dto.idx }">수정</button></td>
		<td><button class="deleteBtn" data-idx="${dto.idx }">삭제</button></td>
	</tr>
	</c:forEach>
</table>

<script>
	const cpath = '${cpath}'
	const modifyBtnList = document.querySelectorAll('.modifyBtn')
	const deleteBtnList = document.querySelectorAll('.deleteBtn')
	
	// 삭제 버튼을 클릭하면 실행되는 함수를 작성
	deleteBtnList.forEach(function(btn) {	// 리스트 내부의 각각의 버튼을 btn이라고 할때
		btn.onclick = function(event) {		// btn을 클릭하면 실행되는 이벤트 함수의 내용
			const idx = event.target.dataset.idx	// 태그에서 data-idx 속성을 불러와서 변수에 저장
			if(confirm('정말 ' + idx + '번 도서를 삭제하시겠습니까?')) {		// 사용자가 확인을 클릭하면
				location.href = cpath + '/' + 'deleteBook/' + idx 	// 삭제 페이지로 이동
			}
		}
	})
	
	// 수정 버튼을 클릭하면 실행되는 함수를 작성
	for(let i = 0; i < modifyBtnList.length; i++) {
		const btn = modifyBtnList[i]
		btn.onclick = function(event) {
			const idx = event.target.dataset.idx
			location.href = cpath + '/' + 'modifyBook/' + idx 	
		}
	}
	
</script>

</body>
</html>