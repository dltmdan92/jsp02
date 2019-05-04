<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		list();
		$("#btnSave").click(function() {
			insert();
			
		});
	});
	
	function insert() {
		/* var param = "userid=" + $("#userid").val() + 
					"&passwd=" + $("#passwd").val() + 
					"&name=" + $("#name").val() + 
					"&address=" + $("#address").val() +
					"&tel=" + $("#tel").val(); */
		
		var param = {
						"userid" : $("#userid").val(),
						"passwd" : $("#passwd").val(),
						"name" : $("#name").val(), 
						"address" : $("#address").val(),
						"tel" : $("#tel").val()
					};
		
		$.ajax({
			type: "post",
			url: "${pageContext.request.contextPath}/member_servlet/join.do",
			data: param,
			success: function() {
				list();
				//입력값 초기화
				$("#userid").val("");
				$("#passwd").val("");
				$("#name").val("");
				$("#address").val("");
				$("#tel").val("");
				$("#userid").focus(); // 입력포커스 이동
			}
		});
	}
	
	function list() {
		$.ajax({
			type: "post",
			url: "${pageContext.request.contextPath}/member_servlet/list.do",
			success: function(result) {
				$("#memberList").html(result);
			}
		});
	}
</script>
</head>
<body>
<h2>회원관리</h2>

아이디 <input id="userid"> <br>
비번 <input type="password" id="passwd"><br>
이름 <input id="name"><br>
주소 <input id="address"><br>
전화 <input id="tel">
<button id="btnSave">추가</button>
<br><br>

<div id="memberList"></div> <!-- 회원목록 출력 -->

</body>
</html>