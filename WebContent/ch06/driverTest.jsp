<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
<%
	Connection conn = null;
	try {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/JSP_DB";
		String dbId = "JSP_DEV";
		String dbPass = "1568919m";
		// jdbc 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(jdbcUrl, dbId, dbPass);
		out.println("오라클에 접속되었습니다.");
	} catch (Exception e) {
		out.println("오라클에 접속되었습니다.");
		e.printStackTrace();
	}
%>
</body>
</html>