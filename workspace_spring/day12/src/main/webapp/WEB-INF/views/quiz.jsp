<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="${cpath }/resources/js/quiz.js"></script>
<h1>사용자 목록</h1>

<form>
	<input type="text" name="username" placeholder="검색할 사용자 이름">
	<input type="submit" value="검색">
</form>

<div id="result">
	<img src="http://221.164.9.222/img/heos.gif">
</div>

<script>
	const cpath='${cpath}'
	const result = document.querySelector('#result')
	const form = document.querySelector('form')
	
	form.onsubmit=function(event){//문서 로딩이 완료되면 호출할 함수
		event.preventDefault()
		const username =event.target.querySelector('input[name ="username"]')
		const url=cpath+'/ajax5?username='+username.value
			const opt={
				method:'GET'
			}
			
			fetch(url, opt)
			.then(resp => resp.json())
			.then(json => render(result, getDom(json)))
		}
</script>


</body>
</html>