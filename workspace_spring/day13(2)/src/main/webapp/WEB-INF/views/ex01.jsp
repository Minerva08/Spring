<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script>
	let scrollCount = 0		// 페이지를 새로고침하기 전까지는 유지되는 변수
	
	async function getBoardData() {	// async : 내부에서 await 키워드를 사용할 수 있다
		const cnt = scrollCount * 5
		const url = cpath + '/getBoardData/' + cnt
		const opt = {
			method: 'GET'
		}
		await fetch(url, opt)	// 이 내용이 처리완료될때까지 잠시 기다린다
		.then(resp => resp.json())
		.then(json => {
			const dom = getDom(json)
			document.body.innerHTML += dom
		})
		console.log(scrollCount)
		scrollCount += 1
	}
	function getDom(json) {
		let dom = ''
		json.forEach(dto => {
			dom += '<div class="item">'
			for(key in dto) {
				dom += '<div >' + dto[key] + '</div>'
			}
			dom += '</div>'
		})
		return dom
	}
	
</script>

<script>
	const body = document.querySelector('body')
	window.onload = async function() {
		await getBoardData()
		await getBoardData()
		await getBoardData()
		await getBoardData()
	}
	window.onscroll = function(event) {
		const t = document.documentElement
// 		console.log(t.scrollTop)
// 		console.log(t.clientHeight)
// 		console.log(t.scrollHeight)
		
		const flag = t.scrollTop + t.clientHeight >= t.scrollHeight
		if(flag) {
			console.log('추가 불러오기')
			getBoardData()
		}
	}
</script>

</body>
</html>