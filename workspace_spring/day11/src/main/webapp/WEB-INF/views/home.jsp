<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="header.jsp" %>
   
<fieldset>
	<h4>요청을 만들어내는 요소들 - 주소가 바뀜</h4>
	
	<ol>
		<li>&lt;a>태그</li>
		<li>&lt;form>태그</li>
		<li>javasrcipt:location.href=url</li>
		<li>★ AJAX(XMLHttpRequest)★</li>
	</ol>
</fieldset>

<h3>AJAX요청을 전달한느 방식에는 XMLHttpRequest, jQuery AJAX, AXIOS, ★fetch등이 있다</h3>
<ul>
	<li><a href="${cpath }/ex01">ex01-ResponseBody</a></li>
	<li><a href="${cpath }/ex02">ex02-fetch</a></li>
</ul>
</body>
</html>