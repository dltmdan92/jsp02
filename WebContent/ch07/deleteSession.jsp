<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/js/jquery-3.4.0.min.js"></script>
</head>
<body>
<%
	//session.removeAttribute("삭제할 변수명");
	//session.removeAttribute("id"); 개발 삭제
	//session.removeAttribute("passwd");
	
	session.invalidate(); //세션 초기화
	// 전체 삭제, 새로운 사용자가 접속한 거로 서버가 인식함 JSESSIONID가 바뀜
	// 세션의 모든 값이 삭제됨, JSESSIONID는 다음에 세션 변수에 값이 입력될 떄 바뀌게됨
%>
세션이 초기화 되었습니다.
<a href="viewSession.jsp">세션 확인</a>
</body>
</html>