<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script>
	function submitHandler(event) {
		event.preventDefault()
		console.log(event.target)
		console.log('submitHandler 호출')
		
		// 1) 입력값을 자바스크립트 객체형태로 준비하기
		const ob = {}	// const는 값이 안바뀌는것이 아니고, 대상이 바뀌지 않는 것이다
		const formData = new FormData(event.target)
		console.log(formData.keys())
		for(key of formData.keys()) {
// 			console.log(key,': ',formData.get(key))
			ob[key] = formData.get(key)
		}
		
		// 2) POST 형식에 맞춰서 서버에 전송하기 (POST요청은 body를 가진다)
		const url = cpath + '/postBoardData'
		const opt = {
			method: 'POST',
			body: JSON.stringify(ob),
			headers: {
				'Content-Type': 'application/json; charset=utf-8'
			}
		}
		
		// 3) 전송 후 받은 응답에 따라 이후 처리 진행
		fetch(url, opt)
		.then(resp => resp.text())
		.then(text => {
			if(text == 1) {
				alert('작성 성공')
				location.href = cpath + '/ex01'
			}
			else {
				alert('작성 실패')
				event.target.reset()	// form 내부의 값을 초기화한다
			}
		})
		
		
	}
</script>

<h2>ajax 로 POST 형식으로 데이터 전송하기</h2>

<div>
	<form>
		<p><input name="title" placeholder="제목" required autofocus></p>
		<p><input name="writer" placeholder="작성자" required></p>
		<p><textarea name="content" placeholder="내용" required></textarea></p>
		<input type="hidden" name="ipaddr" value="${pageContext.request.remoteAddr }">
		<p><button>작성</button></p>
	</form>
</div>

<script>
	const form = document.forms[0]
	form.onsubmit = submitHandler
</script>

</body>
</html>