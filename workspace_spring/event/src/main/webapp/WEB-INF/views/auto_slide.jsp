<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed,
figure, figcaption, footer, header, hgroup,
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure,
footer, header, hgroup, menu, nav, section {
    display: block;
}
body {
    line-height: 1;
}
ol, ul {
    list-style: none;
}
blockquote, q {
    quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
    content: '';
    content: none;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
}
/* ---------위쪽코드는 reset.css------------ */
ul{
    list-style:none;
}
.wrapper{
/*     height:700px; */
    /* background-color: lightgray; */
    display: flex;
    justify-content: center;
    align-items: center;
}
.container{
    width:600px;
    height:400px;
    position: relative;
    background-color: antiquewhite;
    overflow: hidden;
}
.slider{
    display: flex;
    position:absolute;
    top:0;
    left:0;
}
.item{
    width:100%;
    height:400px;
    background-color: yellow;
    font-size: 35px;
    text-align: center;
}
.item:nth-child(2){
    background-color: green;
}
.item:nth-child(3){
    background-color: blue;
}

.container ul{
    -webkit-transition: all 0.25s cubic-bezier(1, .01, .32, 1);
    -o-transition: all 0.25s cubic-bezier(1, .01, .32, 1);
    transition: all 0.25s cubic-bezier(1, .01, .32, 1);
}
	
</style>
</head>
<body>

       <div class="container">
           <ul class="slides">
               <li class="item"><img src="${cpath }/resources/image/flower.jpg" ></li> 
				<li class="item"><img src="${cpath }/resources/image/fox.jpg"></li> 
				<li class="item"><img src="${cpath }/resources/image/lightning.jpg" ></li> 
				<li class="item"><img src="${cpath }/resources/image/moon.jpg" ></li> 
				<li class="item"><img src="${cpath }/resources/image/nature.jpg"></li> 
				<li class="item"><img src="${cpath }/resources/image/space.jpg"></li>
           </ul>
           
           <p class="controller"> 
			<!-- &lang: 왼쪽 방향 화살표 &rang: 오른쪽 방향 화살표 --> 
				<span class="prev">&lang;</span> 
				<span class="next">&rang;</span> 
			</p> 
       </div>
   
</body>
<script>
	const slideWrapper = document.querySelector('.container');
	const slides = document.querySelectorAll('.item');
	const slideImg = document.querySelectorAll(".slides li");//모든 슬라이드들
	const totalSlides = slides.length; // item의 갯수
	
	
	const sliderWidth = slideWrapper.clientWidth; // container의 width
	
	const slides = document.querySelector('.slides');
	
	slides.style.width = sliderWidth * totalSlides + 'px';
	
	showSlides()
	
	function showSlides() {
	   
	}
</script>
</html>