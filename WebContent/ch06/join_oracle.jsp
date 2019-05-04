<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
<script>
	$(function() {
		$("#btnJoin").click(function() {
			var param = {
					"userid": $("#userid").val(),
					"passwd": $("#passwd").val(),
					"name": $("#name").val()
			};
			
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/member_servlet/join_oracle_secret.do",
				data: param,
				success: function() {
					alert("추가되었습니다.");
				}
			});
		});
	});
</script>
</head>
<body>
<h2>회원가입(오라클 암호화)</h2>
아이디 : <input id="userid"><br>
비밀번호 : <input type="password" id="passwd"><br>
이름 : <input id="name">
<button id="btnJoin">회원가입</button>
</body>
</html>