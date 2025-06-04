<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ include file="dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%

		request.setCharacterEncoding("UTF-8");

      	String filename="";
      	String realFolder= request.getServletContext().getRealPath("resources/images");
      	int maxSize=5 * 1024 * 1024;
      	String enctype="utf-8";
      
      	MultipartRequest multi=new MultipartRequest(request, realFolder, maxSize, enctype, new DefaultFileRenamePolicy());
      
      	String bookId=multi.getParameter("bookId");
      	String name=multi.getParameter("name");
      	String unitPrice=multi.getParameter("unitPrice");
      	String author=multi.getParameter("author");
      	String publisher=multi.getParameter("publisher");
      	String releaseDate=multi.getParameter("releaseDate");
      	String description=multi.getParameter("description");
      	String category=multi.getParameter("category");
      	String unitsInStock=multi.getParameter("unitsInStock");
      	String condition=multi.getParameter("condition");
      	
      	Enumeration files = multi.getFileNames();
      	String fname = (String) files.nextElement();
      	String fileName = multi.getFilesystemName(fname);
      	
      	int price;
      	
      	if(unitPrice.isEmpty())
      	{
      		price = 0;
      	}
      	else
      	{
      		price = Integer.valueOf(unitPrice);
      	}
      	
      	long stock;
      	
      	if(unitsInStock.isEmpty())
      	{
      		stock = 0;
      	}
      	else
      	{
      		stock = Long.valueOf(unitsInStock);
      	}
      	
      	PreparedStatement pstmt = null;
      	ResultSet rs = null;
      	
      	String sql="select * from book where b_id=?";
      	pstmt = conn.prepareStatement(sql);
      	pstmt.setString(1, bookId);
      	rs = pstmt.executeQuery();
      	
      	if(rs.next())
      	{
      		if(fileName!=null)
      		{
      			sql="update book set b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=? b_releaseDate=?, b_condition=?, b_fileName=? where b_id=?";
      			pstmt = conn.prepareStatement(sql);
      			pstmt.setString(1, name);
      			pstmt.setInt(2, price);
      			pstmt.setString(3, author);
      			pstmt.setString(4, description);
      			pstmt.setString(5, publisher);
      			pstmt.setString(6, category);
      			pstmt.setLong(7, stock);
      			pstmt.setString(8, releaseDate);
      			pstmt.setString(9, condition);
      			pstmt.setString(10, bookId);
      			pstmt.executeUpdate();
      		}
      	}
      	
      	if(pstmt!=null)
      	{
      		pstmt.close();
      	}
      	if(conn!=null)
      	{
      		conn.close();
      	}
      	
      	response.sendRedirect("editBook.jsp?edit=update");
	%>
</body>
</html>