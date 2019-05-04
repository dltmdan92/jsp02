<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript" src="${path}/js/jquery-3.4.0.min.js"></script>
</head>
<body>
<%
Cookie cookie = new Cookie("id", "");
Cookie cookie2 = new Cookie("pwd", "");
cookie.setMaxAge(0); // 즉시 삭세
cookie2.setMaxAge(0);
// cookie.setMaxAge(-1); 웹브라우저 닫을 때 삭제
// 쿠키를 삭제하는 메서드가 따로 있는것이 아니다.
response.addCookie(cookie);
response.addCookie(cookie2);
%>
쿠키가 삭제되었습니다.
<a href="useCookie.jsp">쿠키 확인</a>

</body>
</html>