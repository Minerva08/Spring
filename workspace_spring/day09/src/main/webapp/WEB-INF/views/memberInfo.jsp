<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2>회원 정보 확인</h2>

<div class="jcce">
	<div>
		<p>ID : ${info.userid }</p>
		<p>PW : ********</p>
		<p>NAME : ${info.username }</p>
		<p>E-Mail : ${info.email }</p>
		<p>Gender : ${info.gender }</p>
		<p>
			<a href="${cpath }/memberUpdate"><button>정보 수정</button></a>
			<button>회원 탈퇴</button>
		</p>
	</div>
</div>

</body>
</html>