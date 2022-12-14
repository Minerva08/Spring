<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
<style>
	h3 {
		margin: 5px;
	}
	.box {
		width: 400px;
		box-sizing: border-box;
		display: flex;
		flex-flow: column;
		justify-content: center;
		border: 2px solid black;
		border-radius: 10px;
		margin-top: 10px;
		padding: 10px;
	}
	.hidden {
		display: none;
	}
</style>
</head>
<body>

<h1>day15 - hash, mail</h1>
<hr>

<form id="sendMailForm">
	<div class="box">
		<h3>이메일 주소 입력</h3>
		<div>
			<input type="email" name="email" placeholder="이메일 주소" 
				   required autofocus autocomplete="off">
			<input type="submit" value="인증번호 전송">
		</div>
		<div id="sendMailMsg"></div>
	</div>
</form>
<form id="authMailForm" class="hidden">
	<div class="box">
		<div style="display: flex; justify-content: space-between;">
			<h3>인증 번호 입력</h3>
			<div class="timer"></div>
		</div>
		<div>
			<input type="text" name="auth" placeholder="인증번호를 입력하세요">
			<input type="submit" value="인증">
		</div>
		<div id="authMailMsg"></div>
	</div>
</form>

<script>
	const sendMailForm = document.getElementById('sendMailForm')
	const sendMailMsg = document.getElementById('sendMailMsg')
	const authMailForm = document.getElementById('authMailForm')
	const authMailMsg = document.getElementById('authMailMsg')
	const cpath = '${pageContext.request.contextPath}'
	
	let second = 180	// 인증번호 입력 시간
	let interval = 0
	
	function timer() {
        let min = Math.floor(second / 60) + ''
        let sec = second % 60 + ''
        if(min.length < 2)  min = '0' + min
        if(sec.length < 2)  sec = '0' + sec

//      const format = `${min} : ${sec}`
		const format = min + ' : ' + sec
        const div = document.querySelector('.timer')
        div.innerText = format

        if(second <= 0) {
            div.style.color = 'red'
            clearInterval(interval)
            authMailForm.querySelector('input').placeholder = '유효시간이 지났습니다'
          	authMailForm.querySelector('input').disabled = 'disabled'
            
            authMailMsg.innerText = '인증번호를 다시 발송해주세요'
           	authMailMsg.style.color = 'red'
        }
        second -= 1
    }
	
	function sendMailHandler(event) {
		event.preventDefault()
		const email = event.target.querySelector('input[name="email"]')
// 		const url = cpath + '/mailto/' + email.value + '/'
		const url = 'http://192.168.0.200:8080/day15/mailto/' + email.value + '/'
		const opt = {
			method: 'GET'
		}
		fetch(url, opt)
		.then(resp => resp.json())
		.then(json => {
			console.log(json)
			sendMailMsg.innerText = json.message
			sendMailMsg.style.color = json.status == 'OK' ? 'blue' : 'red'
			if(json.status == 'OK') {
				authMailForm.classList.remove('hidden')
				
				interval = setInterval(timer, 1000)    // setInterval(함수, ms)
				second = 10	// 메일을 보내고 나면 시간을 초기화한다
				authMailForm.querySelector('input').disabled = ''
				authMailForm.querySelector('input').placeholder = '인증번호를 입력하세요'
				authMailForm.querySelector('input').focus()
				authMailMsg.innerText = ''
			}
		})
	}
	
	// 인증번호를 입력하면 작동하는 함수
	function authMailHandler(event) {
		event.preventDefault()
		if(second <= 0) {
			alert('유효시간이 지났습니다. 다시 메일을 보내주세요')
			return	// 유효시간이 만료되었다면 이후 코드를 진행하지 않는다
		}
		const auth = event.target.querySelector('input[name="auth"]')
		
		const url = cpath + '/getAuthResult/' + auth.value + '/'
		const opt = {
			method: 'GET'
		}
		fetch(url, opt)
		.then(resp => resp.json())
		.then(json => {
			console.log(json)
			authMailMsg.innerText = json.message
			
			if(json.status == 'OK') {
				authMailMsg.style.color = 'blue'
				auth.disabled = 'disabled'
				// 인증에 통과했을 경우 진행할 수 있는 다음 버튼을 보여주거나, 기타 처리를 하면 된다
				clearInterval(interval)
				document.querySelector('.timer').innerHTML = ''
			}
			else {
				authMailMsg.style.color = 'red'
				auth.select()
			}
		})
	}
	
	sendMailForm.onsubmit = sendMailHandler
	authMailForm.onsubmit = authMailHandler
	
	

    
    
    
</script>

</body>
</html>