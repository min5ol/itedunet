<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto1.member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	member mb = (member) request.getAttribute("mb");
%>

<form action="update" method="post">
	<p> 아이디 : <input type="text" name="id" value="<%=mb.getId() %>">
	<p> 비밀번호 : <input type="text" name="password" value="<%=mb.getPassword() %>">
	<p> 이름 : <input type="text" name="name" value="<%=mb.getName() %>">
	<p> <input type="submit" value="수정">
</form>
</body>
</html>