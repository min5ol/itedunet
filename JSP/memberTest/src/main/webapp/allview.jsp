<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="dto1.member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList arr = (ArrayList) request.getAttribute("arr");
	%>
	
	<table>
		<tr>
			<td>아이디</td>
			<td>패스워드</td>
			<td>이름</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		
		<%
		
			for(int i=0; i<arr.size(); i++)
			{
				member mb = (member) arr.get(i);
				
		%>	
		
		<tr>
			<td><%=mb.getId() %></td>
			<td><%=mb.getPassword() %></td>
			<td><%=mb.getName() %></td>
			<td><a href="update?id=<%=mb.getId() %>">수정</a></td>
			<td><a href="delete?id=<%=mb.getId() %>">삭제</a></td>
		</tr>

		<%	
			}
		%>
		
		<a href="index.jsp">Home</a>
	</table>
</body>
</html>