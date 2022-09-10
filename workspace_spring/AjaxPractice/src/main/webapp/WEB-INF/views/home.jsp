<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Todo List</h1>
<div class="list"></div>

<script>
	const cpath = '${cpath}'
	const list = document.body.querySelector('.list')
	const url = cpath+'/todo'
	const opt={
			method:'GET'
	}
	
	fetch(url,opt)
	.then(resp => resp.json())
	.then(json => {
		console.log(json)
		
		json.forEach(dto=>{
			const dom = getDom(dto)
			list.appendChild(dom)
		})
	})
	
	function getDom(dto) {
		const div = document.createElement('div')	// 내가 만든 element에
		div.classList.add('item')
		div.dataset.idx = dto.idx					// 직접 dataset을 추가하기
		
		const div1 = document.createElement('div')
		const title = document.createElement('h3')
		title.innerText = dto.title
		const tdate = document.createElement('div')
		tdate.innerText = new Date(dto.tdate + 1000 * 60 * 60 * 9).toISOString().split('T')[0]
		// toISOString은 영국 런던 표준시 기준이므로 한국은 +0900 이기때문에 9시간만 추가하면 맞는 시간이 된다
		
		div1.appendChild(title)
		div1.appendChild(tdate)
		
		const div2 = document.createElement('div')
		div2.innerText = dto.content
		
		div.appendChild(div1)
		div.appendChild(div2)
	
		return div
	}
	
	
</script>

</body>
</html>