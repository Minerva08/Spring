<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<h2>회원가입</h2>
<form method="POST" action="${cpath }/join">
	<p><input type="text" name="userid" placeholder="ID" required="required" autofocus="autofocus"></p>
	<button id="du">중복확인</button>
	<p id="msg"></p>
	<p><input type="text" name="userpw" placeholder="PW" ></p>
	<p><input type="text" name="username" placeholder="name" ></p>
	<p><input type="email" name="email" placeholder="email" ></p>
	<p><input type="text" name="gender" placeholder="성별" ></p>
	<p><input type="submit" value="가입하기"></p>
</form>

<script>
	const cpath='${cpath}'
	const btn = document.querySelector('#du')
	
	btn.onclick=function(){//문서 로딩이 완료되면 호출할 함수
		event.preventDefault()
		
		const userid =document.querySelector('input[name ="userid"]')
		const userpw = document.querySelector('input[name="userpw"]')
		
		if(userid.value==''){
			alert('ID를 입력해 주세요')
			userid.focus()
			return
		}
		
		 /* const url=cpath+'/ajax6?userid='+userid.value
			const opt={
				method:'GET',
	
			}
			
			fetch(url, opt)
			.then(resp => resp.text())
			.then(result => {
				console.log(result)
				console.log(typeof result)
				if(result.s){
					userpw.select()
				}
				else{
					alert('사용중인 아이디 입니다.')
					userid.select()
				}
			})  */
			
			const url=cpath+'/idcheck/'+userid.value
			const msg = document.querySelector("#msg")
			const opt={
				method:'GET'
			}
			
			fetch(url, opt)
			.then(resp => resp.json())
			.then(json => {
				console.log(typeof json)
				msg.innerText = json.msg
				msg.style.color = json.color
				msg.style.fontweight = 'bold'
				document.querySelector('input[name="'+json.focus+'"]').select()
			})
		} 
</script>




</body>
</html>