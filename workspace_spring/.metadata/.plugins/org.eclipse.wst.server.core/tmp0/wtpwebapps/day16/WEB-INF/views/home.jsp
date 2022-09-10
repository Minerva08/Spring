<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>외부 서버 데이터 받아오기</h1>
<hr>


<script>
// 	const url = 'http://221.164.9.200/memberList'
	const cpath = '${pageContext.request.contextPath}'
	const url = cpath + '/memberList'
	const opt = {
		method: 'GET'
	}
	
	fetch(url, opt)
	.then(resp => resp.json())
	.then(json => render(body,getDom(json)))

</script>

<script>
	function getDom(json){
		console.log('getDom호출')
		console.log(json)
		
		let tag='<table border="1" cellspadding="7" cellspacing="0">'
		
		tag+='<tr>'
		for(key in json[0]){
			tag+='<th>'+key+'</th>'
		}
		console.log(json.length)
		json.forEach(dto => {
			tag+='<tr>'
			for(key in dto){
				const value=dto[key]
				tag+='<td>'+value+'</td>'
			}
		})
		tag+='</tr>'
		tag+='</table>'
		console.log(tag)
			
		return tag;
	}
	
	function render(target,dom){
		console.log('render호출')
		body.innerHTML=dom
	}
</script>

</body>
</html>