<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/js/jquery-3.4.0.min.js"></script>
</head>
<body>
<%
	//	pageContext  <  request  < session(사용자별)  		<  application
	//  현재 페이지 		요청 + 응답     세션만료(로그인 로그아웃까지)	모든사용자	
	Enumeration<String> attr = session.getAttributeNames();
	while(attr.hasMoreElements()) { // 다음 요소가 있으면
		String key = attr.nextElement();
		Object value = session.getAttribute(key);
		out.println("세션변수명 : " + key);
		out.println("세션변수값 : " + value);
	}
	String id = (String) session.getAttribute("id");
	int age = (Integer) session.getAttribute("age");
	double height = (Double) session.getAttribute("height");
	session.setAttribute("age", 30);
%>
아이디 : ${sessionScope.id}
<br>
비번 : ${sessionScope.passwd}
<br>
나이 : ${sessionScope.age}
<br>
키 : ${sessionScope.height}
<br>
세션ID : <%=session.getId()%>
<br>
<a href="deleteSession.jsp">세션 삭제</a>
</body>
</html>