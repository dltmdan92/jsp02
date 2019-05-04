<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="common.Util.Util" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String count = Util.getCookie(request.getCookies(), "count");
int intCount = 0;

Date date = new Date();
long now_time = date.getTime();
String visitTime = Util.getCookie(request.getCookies(), "visit_time");
long visit_time = 0;

if(visitTime != null && !visitTime.equals("")) {
	visit_time = Long.parseLong(visitTime);
}

if(count == null || count.equals("")) {
	response.addCookie(new Cookie("count", "1"));
	response.addCookie(new Cookie("visit_time", Long.toString(now_time)));
	out.println("첫방문을 환영합니다.");
} else {
	long period = now_time - visit_time;
	out.println("현재 : " + now_time + "<br>");
	out.println("최근 : " + visit_time + "<br>");
	out.println("시차 : " + period + "<br>");
	intCount = Integer.parseInt(count);
	if(period > 3 * 1000) {
		intCount++;
		response.addCookie(new Cookie("count", Integer.toString(intCount)));
		response.addCookie(new Cookie("visit_time", Long.toString(now_time)));
	}
	out.println("방문횟수 : " + intCount + "<br>");
	String counter = Integer.toString(intCount);
	for(int i = 0; i < counter.length(); i++) {
		String img = "<img src='../images/" + counter.charAt(i) + ".gif'>";
		out.println(img);
	}
}
%>
</body>
</html>