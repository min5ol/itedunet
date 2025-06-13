<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>
</head>
<body>
	<%
		member mb = (member) request.getAttribute("mb");
	%>
	<form action="update" method="post">
		<p> 아이디: <input type="text" name="id" value="<%=mb.getId()%>" readonly>
		<p> 비밀번호: <input type="text" name="pw" value="<%=mb.getPw() %>">
		<p> <input type="submit" value="수정">
	</form>
</body>
</html>