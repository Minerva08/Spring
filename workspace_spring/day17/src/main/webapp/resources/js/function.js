function getDom(arr) {
	let dom = `<table class="dataTable">`
	dom += `	<thead>`
    dom += `		<tr>`
	dom += `			<th>구분</th>`
	dom += `			<th>사망자 수</th>`
	dom += `			<th>일일 발생자 수</th>`
	dom += `			<th>누적 지역 감염자 수</th>`
	dom += `			<th>누적 유입 감염자 수</th>`
	dom += `			<th>10만명 당 감염자 비율</th>`
	dom += `		</tr>`
	dom += `	</thead>`
	dom += `	<tbody>`
    // 반복 여기부터
	arr.forEach(dto => {
		dom += `<tr>`
		dom += `	<td>${dto.gubun}</td>`
		dom += `	<td>${dto.deathCnt}</td>`
		dom += `	<td>${dto.incDec}</td>`
		dom += `	<td>${dto.localOccCnt}</td>`
		dom += `	<td>${dto.overFlowCnt}</td>`
		dom += `	<td>${dto.qurRate}</td>`
		dom += `</tr>`
	})
    // 반복 여기까지
	dom += `	</tbody>`
	dom += `</table>`
	return dom
}

function getCovidDataJavascript(event) {	// CORS 이슈 해결 (공공데이터포털에서 허용해준것)
	const url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=K7G5hCA%2FRqnmALDK%2F7POZXDGSgTgQFRIcOqpF8HUf9rqLn17QSaJ4Q0Ox732h%2BF%2FgxuyB3bXrdEWApNVwrOtWA%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20211230&endCreateDt=20211230'
	const opt = {
		method: 'GET'
	}
	fetch(url, opt)
	.then(resp => resp.text())
	.then(text => {
		const xml2json = new XMLtoJSON()
		const ob = xml2json.fromStr(text)
		const arr = ob.response.body.items.item.map(v => {
			return {
				gubun: v.gubun['#text'],				// 구분
				deathCnt: v.deathCnt['#text'],			// 누적 사망자 수
				incDec: v.incDec['#text'],				// 일일 감염자 수
				localOccCnt: v.localOccCnt['#text'],	// 지역 감염자 수
				overFlowCnt: v.overFlowCnt['#text'],	// 유입 감염자 수
				qurRate: v.qurRate['#text'], 			// 10만 명 당 감염자 수 비율
			}
		})
		const tmp = arr.splice(0, 1)	// gubun: 검역 데이터만 따로 가져오기
		const sum = arr.splice(17, 1)	// gubun: 합계 데이터만 따로 가져오기
		
		arr.sort((a, b) => {	// 일일 감염자 수를 정수형태로 계산하여 내림차순 정렬
			return +a.incDec < +b.incDec ? 1 : -1
		})
		arr.push(tmp[0])	// 정렬 이후 마지막에 검역 추가
		arr.push(sum[0])	// 정렬 이후 마지막에 합계 추가
		console.log(arr)
		
		root.innerHTML = getDom(arr) // function.js 내부에서 `` 문자열로 만들어서 넣으세요
	})
}

function getCovidDataJava(event) {	// 자바 스프링 서버로 데이터 받아오기
	const url = cpath + '/covid'
	const opt = {
		method: 'GET'
	}
	fetch(url, opt)
	.then(resp => resp.json())
	.then(json => {
		console.log(json)
		const today = json.response.body.items.item[0].createDt.split(' ')[0]
		console.log(today)
		
		const arr = json.response.body.items.item.map(v => {
			return {
				gubun: v.gubun,					// 구분
				deathCnt: v.deathCnt,			// 누적 사망자 수
				incDec: v.incDec,				// 일일 감염자 수
				localOccCnt: v.localOccCnt,		// 지역 감염자 수
				overFlowCnt: v.overFlowCnt,		// 유입 감염자 수
				qurRate: v.qurRate, 			// 10만 명 당 감염자 수 비율
			}
		})
		const tmp = arr.splice(0, 1)	// gubun: 검역 데이터만 따로 가져오기
		const sum = arr.splice(17, 1)	// gubun: 합계 데이터만 따로 가져오기
		
		arr.sort((a, b) => {	// 일일 감염자 수를 정수형태로 계산하여 내림차순 정렬
			return +a.incDec < +b.incDec ? 1 : -1
		})
		arr.push(tmp[0])	// 정렬 이후 마지막에 검역 추가
		arr.push(sum[0])	// 정렬 이후 마지막에 합계 추가
		
		root.innerHTML = getDom(arr) // function.js 내부에서 `` 문자열로 만들어서 넣으세요
	})
}