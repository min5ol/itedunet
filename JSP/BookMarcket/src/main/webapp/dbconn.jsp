<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
		
		try
		{
			String url="jdbc:mysql://localhost:3306/BookMarketDB";
			String user = "root";
			String password = "0508";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url,user,password);
		}
		catch(SQLException ex)
		{
			out.println("데이터베이스 연결 실패.<br>");
			out.println("SQLException: "+ex.getMessage());
		}
	%>
</body>
</html>