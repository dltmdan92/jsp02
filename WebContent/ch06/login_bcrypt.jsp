<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
<script>
$(function() {
	$("#btnLogin").click(function() {
		var param = {
				"userid" : $("#userid").val(),
				"passwd" : $("#passwd").val()
		};
		
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/member_servlet/login_bcrypt.do",
			data : param,
			success : function(result) {
				$("#result").html(result);
			}
		});
	});
});
</script>
</head>
<body>
	<h2>보안 로그인</h2>
	아이디 : <input id="userid"><br>
	비번 : <input type="password" id="passwd"><br>
	<button id="btnLogin">로그인</button>
	<div id="result"></div>
</body>
</html>