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
<c:set var="num" value="<%=new Integer(100)%>" scope="page"/>
<!-- int형으로 넣고싶을 경우 -->
<!-- 아래 처럼 value를 할당할 경우는 무조건 string으로 들어가게 된다. -->
<c:set var="num" value="200" scope="request"/>
<c:set var="num" value="300" scope="session"/>
<c:set var="num" value="400" scope="application"/>

%{pageScope.num}<br>
%{requestScope.num}<br>
%{sessionScope.num}<br>
%{applicationScope.num}<br>

</body>
</html>