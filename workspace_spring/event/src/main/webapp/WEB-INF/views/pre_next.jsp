<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 초기화 */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

li {
	list-style-type: none;
} /* 보여줄 구간의 높이와 넓이 설정 */
#slideShow {
	/*전체 컨테이너*/
	width: 500px;
	height: 300px;
	position: relative;
	margin: 50px auto;
	overflow: hidden;
	/*리스트 형식으로 이미지를 일렬로 정렬할 것이기 때문에, 500px 밖으로 튀어 나간 이미지들은 hidden으로 숨겨줘야됨*/
}

.slides { /*이미지들이 담겨있는 슬라이드 컨테이너*/
	position: absolute;
	left: 0;
	top: 0;
	width: 2500px;
	/* 슬라이드할 사진과 마진 총 넓이 */
	transition: 0.5s ease-out;
	/*ease-out: 처음에는 느렸다가 점점 빨라짐*/
}
/* 첫 번째 슬라이드 가운데에 정렬하기위해 첫번째 슬라이드만 margin-left조정 */
.slides li:first-child {
	margin-left: 100px;
} /* 슬라이드들 옆으로 정렬 */
.slides li:not (:last-child ) {
	float: left;
	margin-right: 100px;
}

.slides li {
	float: left;
}

.controller span {
	position: absolute;
	background-color: transparent;
	color: black;
	text-align: center;
	border-radius: 50%;
	padding: 10px 20px;
	top: 50%;
	font-size: 1.3em;
	cursor: pointer;
} /* 이전, 다음 화살표에 마우스 커서가 올라가 있을때 */
.controller span:hover {
	background-color: rgba(128, 128, 128, 0.11);
}

.prev {
	left: 10px;
}
/* 이전 화살표에 마우스 커서가 올라가 있을때 이전 화살표가 살짝 왼쪽으로 이동하는 효과*/
.prev:hover {
	transform: translateX(-10px);
}

.next {
	right: 10px;
} /* 다음 화살표에 마우스 커서가 올라가 있을때 이전 화살표가 살짝 오른쪽으로 이동하는 효과*/
.next:hover {
	transform: translateX(10px);
}
</style>

</head>
<body>
	<div id="slideShow">
		<ul class="slides">
			<li class="item"><img src="${cpath }/resources/image/flower.jpg"></li>
			<li class="item"><img src="${cpath }/resources/image/fox.jpg"></li>
			<li class="item"><img src="${cpath }/resources/image/lightning.jpg"></li>
			<li class="item"><img src="${cpath }/resources/image/moon.jpg"></li>
			<li class="item"><img src="${cpath }/resources/image/nature.jpg"></li>
			<li class="item"><img src="${cpath }/resources/image/space.jpg"></li>

		</ul>
		<p class="controller">
			<!-- &lang: 왼쪽 방향 화살표 &rang: 오른쪽 방향 화살표 -->
			<span class="prev">&lang;</span> <span class="next">&rang;</span>
		</p>

	</div>
</body>
<script>
	let slides = document.querySelector('.slides');
	let slideImg = document.querySelectorAll('.slides li');
	currentIdx = 0;
	slideCount = slideImg.length;
	prev = document.querySelector('.prev');
	//이전 버튼 
	next = document.querySelector('.next');
	//다음 버튼 

	slideWidth = 300;
	//슬라이드이미지 넓이 
	slideMargin = 100;
	//슬라이드 끼리의 마진값 

	makeClone();
	// 처음이미지와 마지막 이미지 복사 함수 
	initfunction();
	//슬라이드 넓이와 위치값 초기화 함수 

	function makeClone() {
		let cloneSlide_first = slideImg[0].cloneNode(true);
		let cloneSlide_last = slides.lastElementChild.cloneNode(true);
		slides.append(cloneSlide_first);
		slides.insertBefore(cloneSlide_last, slides.firstElementChild);
	}

	function initfunction() {
		slides.style.width = (slideWidth + slideMargin) * (slideCount + 2)
				+ 'px';
		slides.style.left = -(slideWidth + slideMargin) + 'px';
	}

	next.addEventListener('click', function() {
		//다음 버튼 눌렀을때
		if (currentIdx <= slideCount - 1) {
			//슬라이드이동 
			slides.style.left = -(currentIdx + 2) * (slideWidth + slideMargin)
					+ 'px';
			slides.style.transition = '${0.5}s ease-out'; //이동 속도 
		}
		if (currentIdx === slideCount - 1) {
			//마지막 슬라이드 일때 
			setTimeout(function() {
				//0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
				slides.style.left = -(slideWidth + slideMargin) + 'px';
				slides.style.transition = '${0}s ease-out';
			}, 500);
			currentIdx = -1;
		}
		currentIdx += 1;
	});
	prev.addEventListener('click',
			function() {
				//이전 버튼 눌렀을때 
				console.log(currentIdx);
				if (currentIdx >= 0) {
					slides.style.left = -currentIdx
							* (slideWidth + slideMargin) + 'px';
					slides.style.transition = '${0.5}s ease-out';
				}
				if (currentIdx === 0) {
					setTimeout(function() {
						slides.style.left = -slideCount
								* (slideWidth + slideMargin) + 'px';
						slides.style.transition = '${0}s ease-out';
					}, 500);
					currentIdx = slideCount;
				}
				currentIdx -= 1;
			});
</script>

</html>