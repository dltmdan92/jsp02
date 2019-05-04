<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(function() {
	$("#nopopup").click(function() {
		var now = new Date();
		var val = "";
		if(this.checked == true) {
			val = "N";	// 7일간 팝업 안함
		} else {
			val = "Y";	// 7일간 팝업
		}
		setCookie("showCookies", val, 7);
	});
});
function setCookie(cname, cvalue, days) {
	var d = new Date();
	// 만료날짜 설정
	// 초로 설정하는 방법
	d.setTime(d.getTime() + (days * 24 * 60 * 60*1000));
	var expires = "expires=" + d.toGMTString();
	document.cookie = cname + "=" + cvalue + ";" + expires;
	window.close();	// 현재 창 닫기
}
</script>
</head>
<body>
	<input type="checkbox" id="nopopup">
	7일간 보이지 않기
</body>
</html>