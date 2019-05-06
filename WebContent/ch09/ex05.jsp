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
//response.sendRedirect("ex04.jsp?start=2&end=9");
%>
<c:redirect url="ex04.jsp">
	<c:param name="start" value="2"/>
	<c:param name="end" value="9"/>
</c:redirect>
</body>
</html>