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
			System.out.println("데이터베이스 연결🆗");
		}
		else
		{
			System.out.println("데이터베이스 연결❌");
		}
	%>
	
	<%
		PreparedStatement pstmt = null;
		String sql="select * from Member";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
	%>
	
	<%
		while(rs.next())
		{
			String id = rs.getString("id");
			String passwd = rs.getString("passwd");
			String name = rs.getString("name");
	%>
	
	<%= id %>,<%= passwd %>,<%= name %><br>
	
	<%
		}
	%>
</body>
</html>