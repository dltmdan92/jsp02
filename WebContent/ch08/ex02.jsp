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
<form method="get">
	이름 : <input name="name" value="${param.name}">
	<input type="submit" value="확인">
</form>

이름 : ${param.name} <!-- null 처리 포함됨 -->
</body>
</html>