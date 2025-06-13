<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 보기</title>
</head>
<body>
	<%@ include file="welcome.jsp" %>

	<%
		ArrayList<member> arr = (ArrayList<member>) request.getAttribute("arr");
	%>
	
	<table>
		<tr>
			<td> 아이디 </td>
			<td> 비밀번호 </td>
			<td> 수정 </td>
			<td> 삭제 </td>
		</tr>
		<tr>
			<%
				for(int i=0;i<arr.size();i++)
				{
					member mb = arr.get(i);
			%>
			<td><%= mb.getId()%></td>
			<td><%= mb.getPw()%></td>
			<td><a href="update?id=<%=mb.getId() %>">수정</a></td>
			<td><a href="delte?id=<%=mb.getId() %>">삭제</a></td>
		</tr>
			<%
				}
			%>
	</table>
</body>
</html>