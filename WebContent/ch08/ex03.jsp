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
<form method="post" action="ex03_result.jsp">
숫자 <input type="number" name="num">
<input type="submit" value="확인">
</form>
</body>
</html>