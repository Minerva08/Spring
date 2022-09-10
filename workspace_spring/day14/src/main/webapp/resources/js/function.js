function submitHandler(event) {	// 폼이 서브밋될 때 등록하는 함수
	event.preventDefault()
	
	// formData를 가져와서 ob로 만들고 진행하기
	const ob = {}
	const formData = new FormData(event.target)	// 입력된 파라미터를 map처럼 가져온다
	for(key of formData.keys()) {
//		console.log(key, formData.get(key))
		const value = formData.get(key) 
		ob[key] = value
	}
//	console.log(ob)
//	console.log(JSON.stringify(ob))
	
	const url = cpath + '/todo'
	const opt = {
		method: 'POST',
		body: JSON.stringify(ob),
		headers: {
			'Content-Type': 'application/json; charset=utf-8'
		}// text/html, text/css, text/javascript, application/json, image/jpeg 등등
	}
	
	fetch(url, opt)
	.then(resp => resp.text())	// insert의 결과는 0 아니면 1이므로 객체로 처리하지 않는다 
	.then(text => {
		console.log(text)
		// 결과가 성공이라면, 입력된 form을 초기화하고 (form.reset())
		// 기존에 화면에 있는 목록을 제거한 후
		// 목록을 새로 불러온다
		// 등록 성공 메시지를 alert으로 출력한다
		if(text == 1) {
			event.target.reset()
			list.innerHTML = ''
			loadHandler()	// 이미 만들어진 함수를 재사용하기
			alert('등록 성공 !!')
		}
		else {
			event.target.querySelector('input').select()
			alert('등록 실패...')
		}
	})
}

function rightClickHandler(event) {
	event.preventDefault()
	let target = event.target
	while(target.classList.contains('item') == false) {
		target = target.parentNode
	}
//	alert('우클릭 이벤트 발생 : ' + target.dataset.idx) 
	// 이건 우클릭해서 confirm 받고 확인하면 삭제하는 코드로 사용할 예정
	console.log(target.dataset.idx)
	const flag = confirm(`${target.dataset.idx} 번 일정을 삭제하시겠습니까?`)
	if(flag == false){
		return	// 취소를 선택했다면 더이상 함수를 진행하지 않겠다
	}
	const url = cpath + '/todo/' + target.dataset.idx
	const opt = {
		method: 'DELETE'	// @DeleteMapping("/todo/{idx}")
	}
	fetch(url, opt)
	.then(resp => resp.text())	// insert의 결과는 0 아니면 1이므로 객체로 처리하지 않는다 
	.then(text => {
		console.log(text)
		// 결과가 성공이라면, 입력된 form을 초기화하고 (form.reset())
		// 기존에 화면에 있는 목록을 제거한 후
		// 목록을 새로 불러온다
		// 등록 성공 메시지를 alert으로 출력한다
		if(text == 1) {
			event.target.reset()
			list.innerHTML = ''
			loadHandler()	// 이미 만들어진 함수를 재사용하기
			alert('삭제 성공!!')
		}
		else {
			event.target.querySelector('input').select()
			alert('삭제 실패')
		}
	})
}

function getDom(dto) {
	const div = document.createElement('div')	// 내가 만든 element에
	div.classList.add('item')
	div.dataset.idx = dto.idx					// 직접 dataset을 추가하고
	div.oncontextmenu = rightClickHandler		// 미리 정의해둔 이벤트함수를 연결할 수도 있다
	
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

function getDom2(dto) {
	let dom = ``
	dom += `<div class="item" data-idx="${dto.idx}">`
	dom += `	<div>`
	dom += `		<h3>${dto.title}</h3>`
	dom += `		<div>${new Date(dto.tdate + 1000*60*60*9).toISOString().split('T')[0]}</div>`
	dom += `	</div>`
	dom += `	<div>${dto.content}</div>`
	dom += `</div>`
	return dom
}

async function loadHandler(event) {	// 문서 로딩이 끝나면 목록을 불러와서 화면에 보여주는 함수
	const url = cpath + '/todo'
	const opt = {
		method: 'GET'
	}
	
	await fetch(url, opt)
	.then(resp => resp.json())
	.then(json => {
		console.log(json)
		for(dto of json) {
//			const dom = getDom(dto)		// element
			const dom = getDom2(dto)	// string
			
			if(typeof dom == 'string') {
				list.innerHTML += dom
			}
			
			else {
				list.appendChild(dom)
			}
		}
		const items = list.querySelectorAll('.item')
//		items.forEach(item => item.oncontextmenu = rightClickHandler)
	})
}