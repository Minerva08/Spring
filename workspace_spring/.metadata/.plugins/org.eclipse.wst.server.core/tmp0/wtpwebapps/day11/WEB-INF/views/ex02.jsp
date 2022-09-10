<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div>
	<input type="number" name="n1" min="0" max="100" placeholder="n1">
	+
	<input type="number" name="n2" min="0" max="100" placeholder="n2">
	<input type="button" value="=">
	<span id="result"></span>
</div>

<script>
	const btn = document.querySelector('input[type="button"]')
	
	btn.onclick = function() {	// 사용자가 버튼을 클릭하면
		// 변수 선언
		const n1 = document.querySelector('input[name="n1"]').value		// 값을 불러온다	
		const n2 = document.querySelector('input[name="n2"]').value
		
		const url = '${cpath}/ex02Ajax?n1=' + n1 + '&n2=' + n2
		const opt = {
			method: 'GET'
		}
		
		fetch(url, opt)				// 1) 주소와 옵션으로 요청을 보낸다
		
		.then(resp => resp.text())	// 2) 응답을 텍스트 형태로 변환한다
		
		.then(text => {				// 3) 텍스트 형태의 응답을 result 태그 내부에 글자로 적는다
			document.getElementById('result').innerText = text
		})

	}
	
</script>

</body>
</html>



