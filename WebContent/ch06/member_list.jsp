<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript">
	function view(userid) {
		document.form1.userid.value=userid;
		document.form1.submit();
	}
</script>

</head>
<body>
<%
	Map<String, Object> map = (Map<String, Object>) request.getAttribute("map");
	int count = (int) map.get("count");
	List<MemberDTO> list = (List<MemberDTO>) map.get("list");
%>
	등록된 회원수 : <%=count%>명
	<table border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>가입일자</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
	<%	for(MemberDTO dto : list) { %>
		<tr>
			<td><a href="#" onclick="view('<%=dto.getUserid()%>')"><%=dto.getName()%></a></td>
			<td><%=dto.getUserid()%></td>
			<td><%=dto.getPasswd()%></td>
			<td><%=dto.getReg_date()%></td>
			<td><%=dto.getAddress()%></td>
			<td><%=dto.getTel()%></td>
		</tr>
	<% 	}  %>
	</table>
	<form name="form1" method="post" action="${pageContext.request.contextPath}/member_servlet/view.do">
		<input type="hidden" name="userid">
	</form>
</body>
</html>