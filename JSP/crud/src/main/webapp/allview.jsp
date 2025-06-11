<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ %>
<!DOCTYPE html>
<html>
<head>
 <link href = "./resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="nav.jsp" %>
    
    <%
       ArrayList<member> arr = (ArrayList<member>) request.getAttribute("arr");
    %>
    
    <h1>전체멤버 출력</h1>
    <table>

    </table>
</body>
</html>