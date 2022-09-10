<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨</title>
</head>
<body>
	<h1>날씨</h1>
	<hr>
	<div id="root"></div>
	<script>
		const root = document.getElementById('root')
		const cpath ='${cpath}'
		
		async function getMidLandFcst(){
			const url=cpath+'/midLandFcst'
			const opt={
					method:'GET'
			}
			const json = await fetch(url,opt).then(resp=> json())
			return json
		}
		
		async function getMidTa(){
			const url=cpath+'/midTa'
			const opt={
					method:'GET'
			}
			const json=await fetch(url,opt).then(resp => resp.json())
			return json
		}
		
		async function main(){
			const midLandFcst = await getMidLandFcst()
			const ob1=midLandFcst.response.body.items.item[0]
			
			const midTa = await getMidTa()
			const ob2 = midTa.response.body.items.item[0]
			
			console.log(1,ob1)
			console.log(2,ob2)
		}
		window.onload= main
		
	</script>
</body>
</html> 