<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="${cpath }/resources/js/ex04.js"></script>
	<h2>member 목록으로 테이블 만들기</h2>
	
	<div id="result">
		<img src="http://221.164.9.222/img/heos.gif">
	</div>
<script>
	const cpath='${cpath}'
	const result = document.querySelector('#result')
	
	window.onload=function(){//문서 로딩이 완료되면 호출할 함수
		const url=cpath+'/ajax4'
		const opt={
			method:'GET'
		}
		
		fetch(url, opt)
		.then(resp => resp.json())
		.then(json => render(result,getDom(json)))
	}
	
	
</script>
</body>
</html>