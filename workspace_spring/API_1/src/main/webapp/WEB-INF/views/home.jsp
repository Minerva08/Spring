<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:if test="${not empty login}">
<a href="${cpath }/logout">로그아웃</a>
</c:if>
<c:if test="${empty login}">
<a href="${cpath }/login">로그인</a>
<h4><a href="${cpath }/join" style="text-decoration: none; color: black;">아직 회원이 아니신가요?</a></h4>
</c:if>
<a href="${cpath }/list">회원 리스트</a>
<a href="${cpath }/addr">주소 입력</a>


</body>
</html>