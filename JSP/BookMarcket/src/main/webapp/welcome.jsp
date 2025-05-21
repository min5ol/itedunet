<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://kit.fontawesome.com/7d59311e3d.js" crossorigin="anonymous"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<header class="pb-3 mb-4 border-bottom">
		<a href="./welcom.jsp" class="d-flex align-items-center text-dark text-decoration-none">
			<i class="fa-solid fa-house-chimney"></i>
			<span class="fs-4">Home</span>
		</a>
	</header>
	
	<%! String greeting = "Welcome to Book Shopping Mall";
		String tagline = "Welcome to Web Market!";
	%>
	
	<div class="p-5 mb-4 bg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold"><%=greeting %></h1>
			<p class="col-md-8 fs-4">BookMarket</p>
		</div>
	</div>

	<div class="row align-items-md-stretch text-center">
		<div class="col-md-12">
			<div class="h-100 p-5">
				<h3><%=tagline %></h3>
			</div>
		</div>
	</div>
	
	<footer class="pt-3 mt-4 text-body-secondary border-top">
		&copy; BookMarket
	</footer>
</body>
</html>