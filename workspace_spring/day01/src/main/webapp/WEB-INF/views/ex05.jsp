<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex05 - 경로 변수</h1>
<hr>

<h3>${msg }</h3>

<form>
        <input name="name">
        <input type="submit" value="전송">
</form>
<script>
        const form = document.forms[0]
        
        form.onsubmit = function(event) {
                event.preventDefault()
                const name = form.children[0].value
                alert(name)
                const cpath = '${pageContext.request.contextPath}'
                location.href = cpath + '/ex05/' + name
        }
</script>


</body>
</html>