const uploadForm = document.getElementById('uploadForm')

uploadForm.onsubmit = function(event) {
	event.preventDefault()		// submit을 시도하면 일단 막는다
	console.log('login : ' + login)
	if(login == '') {
		alert('로그인 하셔야 파일 업로드가 가능합니다')
// 			return
	}
	event.target.submit()		// 상단의 if에서 종료되지 않으면 의도했던 대로 제출해라
}

uploadForm.querySelector('input[name="uploadUser"]').onclick = function(event) {
	if(login == '') {
		location.href = cpath + '/login'
	}
}
	