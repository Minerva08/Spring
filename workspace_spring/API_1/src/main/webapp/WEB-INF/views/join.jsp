<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" placeholder="아이디" required autofocus></p>
	<p><input type="text" name="userpw" placeholder="비밀번호" required ></p>
	<p><input type="text" name="username" placeholder="이름" required ></p>
	<p><input type="text" name="email" placeholder="이메일" required ></p>
	<p>
		<input type="text" id="addr1" onclick="execPostcode()" name="addr1" placeholder="우편번호" readonly>
		<input type="button" onclick="execPostcode()" value="우편번호 찾기" readonly>
		<br>
		<input type="text" id="addr2" onclick="execPostcode()" name="addr2" placeholder="도로명주소" readonly>
		<input type="text" id="addr3" onclick="execPostcode()" name="addr3" placeholder="지번주소" readonly>
		<br>
		<input type="text" id="addr4" name="addr4" placeholder="상세주소" required>
		<!-- <input type="text" id="sample4_extraAddress" placeholder="참고항목" readonly> -->
	</p>
	<p><input type="submit" value="회원가입"></p>
</form>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('addr1').value = data.zonecode;
                document.getElementById("addr2").value = roadAddr;
                document.getElementById("addr3").value = data.jibunAddress;
                
                console.log(data.zonecode)
                console.log(roadAddr)
                console.log(data.jibunAddress)
                console.log(data.detailAddress)
             
            }
        }).open();
    }
</script>
</body>
</html>