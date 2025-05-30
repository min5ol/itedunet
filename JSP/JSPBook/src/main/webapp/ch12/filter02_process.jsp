<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter</title>
</head>
<body>
	<%
		String id = (String)request.getAttribute("id");
		String passwd = (String)request.getAttribute("passwd");
	%>
	<p>입력된 id 값: <%=id %>
	<p>입력된 pw 값: <%=passwd %>
</body>
</html>