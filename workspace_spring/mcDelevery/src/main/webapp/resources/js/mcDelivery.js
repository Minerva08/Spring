function getDomFromDTO(dto) {
	let dom = ``
	dom += `<div class="item">`
	dom += 	`<div class="img">`
	dom += 	`<img src="${dto.img}">`
	dom += 	`</div>`
	dom += `<div class="name">${dto.name}</div>`
	dom += `<div>`
	dom += `<div>`
	dom += `<div class="price">${dto.price}</div>`
	dom += `<div class="kcal">${dto.kcal}</div>`
	dom += `<div class="alergy">알레르기 정보</div>`
	dom += `</div>`
	dom += `<div>`
	dom += 	`<button>order</button>	`		
	dom += `</div>`
	dom += `</div>`
	dom += `</div>`
	return dom
}

function render(target) {
	
	const url = cpath + '/ajaxProductList'
	const opt = {
		method: 'GET'
	}
	
	fetch(url, opt)					// 주소와 옵션으로 요청을 서버에 전송하면
	.then(resp => resp.json())		// 응답이 돌아오는데, 응답을 json형태로 변환
									// 서버에서 보낸 데이터가 List<DTO> 이니까 js의 배열형태로 들어온다
	.then(json => {					// 변환이 끝난 데이터(json, array)를 어디에 사용할 것인가
		target.innerHTML = ''		// 대상의 내부 태그를 제거하고
		json.forEach(dto => {		// 배열의 각각을 dto라고 하면
//			console.log(dto)	
			const dom = getDomFromDTO(dto)	// dto를 이용해서 태그형태 문자열로 변환하고
			target.innerHTML += dom			// 그 문자열을 대상의 내부에 HTML 태그형식으로 삽입
		})
	})
	
}