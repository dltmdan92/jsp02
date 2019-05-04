<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<%@ include file="../include/session_check.jsp" %>
<script type="text/javascript" src="${path}/js/jquery-3.4.0.min.js"></script>
<script>
$(document).ready(function() {
	$("#btnLogout").click(function() {
		location.href="${path}/session_servlet/logout.do";	
	});
});
</script>
</head>
<body>
<h2><%=session.getAttribute("message")%></h2>
<%=session.getAttribute("userid")%>님이 접속중입니다.

<h2>${sessionScope.message}</h2>
${sessionScope.userid}님이 접속중입니다.
<br>
<button type="button" id="btnLogout">로그아웃</button>

</body>
</html>