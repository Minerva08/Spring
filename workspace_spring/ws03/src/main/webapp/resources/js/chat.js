const btn = document.getElementById('btn')
const send = document.getElementById('send')
const textarea = document.getElementById('textarea')
const quit = document.getElementById('quit')
const ws = new SockJS(cpath + '/chat?id=' + username, null, {sessionId: generateSessionId}) // 스프링에서 지정한 주소에 대한 컴포넌트를 작성해야 한다

function generateSessionId() {
	return username + '_' + new Date().getTime()
}

ws.onmessage = onMessage
ws.onopen = onOpen
ws.onclose = onClose
ws.onerror = function(msg) {}

btn.onclick = sendHandler // 버튼을 클릭하면 보내는 함수를 호출한다
send.onkeydown = keyHandler // 엔터버튼 누르면 보내는 함수로 연결한다
quit.onclick = quitHandler 	// 나가기 버튼 누르면 종료 함수를 호출한다
window.onload = loadPeopleHandler

// 웹소켓 내부에서 사용할 함수를 정의하는 영역
function onMessage(event) { // 메시지를 받으면 수행하는 자바스크립트 함수
	const wrap = document.createElement('div')
	const name = document.createElement('div')
	const message = document.createElement('span')

	name.innerText = JSON.parse(event.data).username
	const flag = JSON.parse(event.data).message.includes('http://') || 
				 JSON.parse(event.data).message.includes('https://')|| 
				 JSON.parse(event.data).message.includes('www')

	// 채팅 내용이 웹 주소라면 링크형식으로 만드는 조건
	if (flag) {
		message.innerHTML = '<a class="link" href="'
				+ JSON.parse(event.data).message + '" target="_blank">'
				+ JSON.parse(event.data).message + '</a>'
	} 
	else {
		message.innerText = JSON.parse(event.data).message
	}
	name.classList.add('name')
	message.classList.add('message')

	wrap.appendChild(name)
	wrap.appendChild(message)
	
	// self, other, alarm 처리하기
	wrap.classList.add(name.innerText == 'alarm' ? 'alarm' : name.innerText == username ? 'self' : 'other')
	if(wrap.className == 'alarm') {
		loadPeopleHandler()
	}

	textarea.appendChild(wrap)
	textarea.scroll({
		top : textarea.scrollHeight,
		behavior : 'smooth'
	})
	// 메시지를 받으면 높이만큼 계산해서 부드럽게 스크롤 이동시키기
}

function loadPeopleHandler(event) {
	setTimeout(500)
	const url = cpath + '/loadPeople'
	const opt = {
		method: 'GET'
	}
	fetch(url, opt)
	.then(resp => resp.json())
	.then(json => {
		const right = document.querySelector('.right')
		right.innerHTML = ''
		for(let i = 0; i < json.length; i++) {
			const div = document.createElement('div')
			div.innerText = json[i]
			div.classList.add('peopleName')
			right.appendChild(div)
		}
	})
}

function onOpen(event) {
//	ws.send(JSON.stringify({
//		username : 'alarm',
//		message : username + ' 님이 입장하였습니다(JS).'
//	}))
}

function onClose(event) {
}

function quitHandler(event) {
	ws.send(JSON.stringify({
		username : 'alarm',
		message : username + ' 님이 퇴장하였습니다.'
	}))
	ws.close()
	location.replace(cpath + '/logout')
}

function keyHandler(event) {
	if (event.key == 'Enter') {
		sendHandler(event)
	}
}

function sendHandler(event) { // 메시지를 보내는 자바스크립트 함수
	const message = send.value
	send.value = ''
	if(message.replace(/ /gi, '') == '') {
		alert('도배 금지 !!')
		return
	}
	if(message.includes('　')) {
		alert('도배 금지 !!')
		return
	}
	if(message.includes('ㅤ')) {
		alert('도배 금지 !!')
		return
	}
	ws.send(JSON.stringify({
		username : username,
		message : message
	}))
	send.focus()
}