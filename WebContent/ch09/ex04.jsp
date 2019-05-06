<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript" src="${jsPath}/jquery-3.4.0.min.js"></script>
</head>
<body>
<%
for(int i=0; i<10; i++) {
	
}
%>

<c:forEach var="i" begin="0" end="9" step="1" varStatus="no">
${i},
${no.count}<br>
</c:forEach>
<!-- step에는 마이너스 값은 넣을 수 없음 -->

<c:forEach var="i" begin="0" end="9" step="1" varStatus="num">
${i},
${num.index}<br>
</c:forEach>

<c:forEach var="i" begin="0" end="20" step="1">
${20-i} <br>
</c:forEach>

<c:forEach var="i" begin="${param.start}" end="${param.end}">
	<h2>${i}단</h2>
	<c:forEach var="j" begin="1" end="9">
		${i} x ${j} = ${i * j}<br>
	</c:forEach>
</c:forEach>
</body>
</html>