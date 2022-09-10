 

function getVaccine(event) {
	const vacUrl = cpath + '/vaccine' 
	
	const opt = {
			method: 'GET'
		}
	
	fetch(vacUrl, opt)
	.then(resp => resp.json())
	.then(json => {
		console.log(json)
		const arr = json.data.map(v => {
			return {
				'날짜' : v.baseDate.substring(5,10),
				'1차 접종 완료' : v.totalFirstCnt,
				'2차 접종 완료' : v.totalSecondCnt,
				'3차 접종 완료' : v.totalThirdCnt,
			}
		})
		console.log(arr)
		renderVaccine(arr)
	// 1) 데이터를 배열로 준비
	const arr2 = [
	   
	]

	for(key in arr){
		arr2.push([ 
			arr[key]['날짜'], arr[key]['1차 접종 완료'], arr[key]['2차 접종 완료'], arr[key]['3차 접종 완료']
		])
	}

	console.log('arr2', arr2) 
	
	
	
	// 2) 테이블 생성
	const table = new google.visualization.DataTable()
	
	// 3) column 추가 (컬럼 이름 및 자료형)
	table.addColumn('string', '날짜')
	table.addColumn('number', '1차 접종 완료')
	table.addColumn('number', '2차 접종 완료')
	table.addColumn('number', '3차 접종 완료')
	
	// 4) row 추가 (실제 데이터)
	table.addRows(arr2)
	
	// 5) 시각화 (dom을 지정)
		const opt2 = {
		    title: '일자별 코로나 백신 접종',
		    width: 1900,
		    height: 450,
		}

	const chart = new google.visualization.ColumnChart(root)

	chart.draw(table,opt2)	
		
		
	})

}

