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
		
		String url="jdbc:mysql://localhost:3306/BookmarketDB";
		
		String user="root";
		String pw="0508";
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,pw);
		
		if(conn==null)
		{
			System.out.println("데이터베이스가 연결 되지 않았습니다.");
		}
		else
		{
			System.out.println("데이터베이스가 연결 되었습니다.");
		}
	%>
	
	<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		System.out.println(id);
		System.out.println(passwd);
		System.out.println(name);
		
		Statement stmt = null;
		
		String sql ="insert into Member(id,passwd,name) values('"+id+"','"+passwd+"','"+name+"')";
		
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		
	%>
</body>
</html>