<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//session.setMaxInactiveInterval(3600);

// 세션의 유효시간(초)
int timeout = session.getMaxInactiveInterval();
out.println("세션의 유효시간 : " + timeout);
%>
</body>
</html>