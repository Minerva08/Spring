function getBookContent(dto){
	console.log('div 생성')
	const div = document.createElement('div')
	div.classList.add('item')
	document.body.appendChild(div)
	
	const h4 = document.createElement('h4')
	h4.innerText=dto.idx
	div.appendChild(h4)
	
	const rank = document.createElement('p')
	rank.innerText=dto.rank
	let check = rank.innerText
	console.log(check)
	console.log(check[0])
	if(check=='New'){
		rank.style.color='red'
		rank.style.fontSize='5px'
	}
	
	else{
		if(check[0]=='▲'){
			rank.style.color='red'
				rank.style.fontSize='5px'
			
		}
		if(check[0]=='▼'){
			rank.style.color='blue'
				rank.style.fontSize='5px'
					
		}
		if(check[0]=='-'){
			rank.style.color='black'
			rank.style.fontSize='5px'
			
		}
				
	}

	div.appendChild(rank)
	
	const content = document.createElement('div')
	content.classList.add('content')
	div.appendChild(content)
	
	const img = document.createElement('img')
	img.src=dto.img
	img.alt='도서이미지'
	content.appendChild(img)
	
	
	const title = document.createElement('div')
	title.classList.add('title')
	content.appendChild(title)
	
	const a = document.createElement('a')
	a.innerText=dto.title
	title.appendChild(a)
	
	const writer = document.createElement('div')
	writer.classList.add('writer')
	console.log(dto.writer)
	writer.innerText=dto.writer
	content.appendChild(writer)
	
	return div
}


function render(dom){
	console.log('render')
	const result = document.querySelector('.result')
	result.appendChild(dom)
		
}