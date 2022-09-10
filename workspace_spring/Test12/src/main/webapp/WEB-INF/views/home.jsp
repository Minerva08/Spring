<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath">${pageContext.request.contextPath }</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공공 데이터 포털 코로나 시도 발생현황</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css"> 
</head>
<body>
<script src="${cpath }/resources/js/function.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<h1>Test12</h1>
<hr>

<div id="root2"></div>
<div id="root"></div>

<script>
	const root = document.getElementById('root')
	const cpath = '${cpath}'
	const root2 = document.getElementById('root2')
	
	window.onload=function(){
		const covidInfURL = cpath + '/covid'
		const opt ={method: 'GET'}
		   
		   fetch(covidInfURL, opt)
		   .then(resp => resp.json())
		   .then(json => {
		      const arr = json.response.body.items.item.filter(v => v.gubun == '부산')
		      .map(v =>{
		         return {
		            '날짜': v.createDt.split(' ')[0].split('-')[1]+'/'+v.createDt.split(' ')[0].split('-')[2],
		            '지역확진자': v.localOccCnt,
		         }
		      })
		    google.charts.load('current',{packages:['corechart']})
		    google.charts.setOnLoadCallback(drawChart)
		    
		    function drawChart(){
		      console.log(arr)
		      arr.sort((a, b) => {	// 일일 감염자 수를 정수형태로 계산하여 내림차순 정렬
					return +a.incDec < +b.incDec ? 1 : -1
				})
	    	  const Person=[]
	    	  for(key in arr){
	    		  Person.push([arr[key]['날짜'],arr[key]['지역확진자']])
	                
	           }
    	     //2)테이블 생성
    	    const table = new google.visualization.DataTable()
    	    //3)colum추가(컬럼이름 및 자료형)
    	    table.addColumn('string','날짜')
    	    table.addColumn('number','지역확진자')

    	    //4)row추가(실제 데이터)
    	    table.addRows(Person)
    	    //5)시각화 (dom 지정)
    	    const Opt={
    	        title:'일자별 코로나 확진자',
    	            width:1900,
    	            height:450,
    	        }
    	  
    	    
    	        const chart=new google.visualization.ColumnChart(root)
    	        chart.draw(table,Opt)

    	   }
		      
		  
		     
		  })
		  
		const vurl = cpath + '/vaccine'
	   const vopt = {
	       method: 'GET'
	    }
	    fetch(vurl,vopt)
	    .then(resp => resp.json())
	    .then(json =>{
	       google.charts.load('current',{packages: ['corechart']})
	       google.charts.setOnLoadCallback(vaccineFunction)
	       const vArr = json.data.map(v=>{
	          return{
	             date: (v.baseDate.split(' ')[0]).split('2022-')[1].replace('-','/'),
	             first: v.totalFirstCnt,
	             second: v.totalSecondCnt,
	             third: v.totalThirdCnt
	          }
	       })
	              
	      vaccineFunction(vArr)
	      
	      function vaccineFunction(){
	          
	          const arr = []
	          
	          for(i in vArr){
	             arr.push([vArr[i].date, vArr[i].first, vArr[i].second, vArr[i].third])
	          }
	          
	          console.log(arr)
	          
	          const table = new google.visualization.DataTable()
	          
	          table.addColumn('string','날짜')
	          table.addColumn('number','1차 접종 완료')
	          table.addColumn('number','2차 접종 완료')
	          table.addColumn('number','3차 접종 완료')

	          table.addRows(arr)
	          
	          const opt = {
	             title: '일자별 코로나 백신 접종',
	             width: 1900,
	             height: 450,
	          }
	          
	          const chart = new google.visualization.ColumnChart(root2)
	           chart.draw(table,opt)
	       }
	    })
		  
		  
	}
	
	
	
	

</script> 



</body>
</html>