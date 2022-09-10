<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script>
	function ajaxHandler(event){
		const url=cpath+'/ajax1'
		const opt={
				method:'GET'
				
		}
		
		fetch(url,opt)				          	  //요청을 전달하고
		.then(resp => {
			resp.text()
			console.log(resp)
		})	          							//응답을 원하는 형태로 변환한다
		
		.then(text => result.innerText=text)  //변환된 데이터를 문서에 반영한다
		
	}
</script>
<h2>기본 GET요청</h2>

<button id="btn">요청</button>
<div id="result"></div>

<script>
	const cpath = '${cpath}'
	const btn = document.querySelector('#btn')
	const result = document.querySelector('#result')
	
	btn.onclick = ajaxHandler
	
</script>

</body>
</html>