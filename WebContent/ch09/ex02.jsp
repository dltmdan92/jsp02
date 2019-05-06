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
<c:set var="country" value="korea"/>

<c:if test="${country != null}">
	국가명 : ${country}<br>
	국가명 : <c:out value="${country}" /> <br>
</c:if>

<%
int[] nums = {10, 70, 80, 50, 40, 30, 20};
%>

<c:set var="num" value="<%=nums%>"/>
<!-- var 개별값, value 집합 -->

<c:forEach var="n" items="${num}">
	${n},
</c:forEach>
<br>

</body>
</html>