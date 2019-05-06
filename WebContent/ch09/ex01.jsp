<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
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
Enumeration<String> headerNames = request.getHeaderNames();

while(headerNames.hasMoreElements()) {
	String key = headerNames.nextElement();
	String value = request.getHeader(key);
	out.println(key + " : " + value + "<br>");
}
%>

<!-- 
EL의 내장변수
${cookie},  ${header}
 -->
 <c:forEach var="h" items="${header}">
 	${h.key} => ${h.value}<br>
 </c:forEach>

<c:set var="browser" value="${header['user-agent']}"/>
<hr>

<c:out value="${browser}"/>
<br>
${browser}
<hr>

<c:remove var="browser"/>
<c:out value="${browser}"/>

</body>
</html>