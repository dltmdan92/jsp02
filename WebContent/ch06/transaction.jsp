<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="emp.dao.EmpDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<%
	EmpDAO dao = new EmpDAO();
	dao.insert();
	dao.insert_batch();
%>
</body>
</html>