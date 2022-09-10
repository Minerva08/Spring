function render(target,dom){
	console.log('render호출')
	result.innerHTML = dom
	
}

function getDom(json){
	console.log('getDomg 호출')
	console.log(json)
	
	let tag=`<table border="1" cellspadding="7" cellspacing="0">`
	
	tag+=`<tr>`
	for(key in json[0]){
		tag+=`<th>${key}</th>`
	}
	tag+=`</tr>`
		
	json.forEach(dto => {
		tag+=`<tr>`
		for(key in dto){
			const value=dto[key]
			tag+=`<td>${value}</td>`
		}
	})
	
	tag+=`</tr>`
	tag+=`</table>`
	console.log(tag)
	return tag
		
}