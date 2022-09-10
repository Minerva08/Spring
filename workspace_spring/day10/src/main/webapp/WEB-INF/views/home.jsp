<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="loginInfo" >
	<c:if test="${empty login }">
		<form id="loginForm" method="POST" action="${cpath }/login">
			<input type="text" name="userid" placeholder="ID">
			<input type="password" name="userpw" placeholder="Password">
			<input type="submit" value="로그인">
		</form>
	</c:if>
	<c:if test="${not empty login }">
		${login.userid }
		&nbsp;
		<a href="${cpath }/logout"><button>로그아웃</button></a>
	</c:if>
</div>

<hr>

<div>
	<form id="uploadForm" method="POST" enctype="multipart/form-data" action="${cpath }/upload">
		<div><input type="text" name="uploadUser" value="${login.userid }" placeholder="로그인이 필요합니다" readonly></div>
		<div><input type="file" name="uploadFile"></div>
		<div><input type="submit" value="전송"></div>
	</form>
</div>
<div id="imageList">
	<c:forEach var="dto" items="${list }">
	<div class="item">
		<div class="image">
			<a href="${cpath }/upload/${dto.storedFileName }" target="_blank">
				<img src="${cpath }/upload/${dto.storedFileName }" width="200px"></a>
			
		</div>
		<div>
			<div class="originalFileName">${dto.originalFileName }</div>
			<div class="storedFileName">${dto.storedFileName }</div>
			<div class="uploadDate"><fmt:formatDate value="${dto.uploadDate }" pattern="yyyy-MM-dd a hh:mm" /></div>
			<div class="uploadUser">${dto.uploadUser }</div>
		</div>
	</div>
	</c:forEach>
</div>

<script src="${cpath }/resources/js/formModule.js"></script>


</body>
</html>