<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<script src="<c:url value="/resources/js/controllers.js"/>"></script>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
	<div class="container">
		<div>
			<form:form method="POST" action="<c:url value='/cart/clear'/>">
  				<button type="submit" class="btn btn-danger">전체삭제</button>
			</form:form>

			<a href="<c:url value="/order?cartId=${cartId}"/>" class="btn btn-success float-right">주문하기</a>
		</div>
		<div style="padding-top: 50px">
			<table class="table table-hover">
				<tr>
					<th>도서</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>
				</tr>
				<form:form name="removeForm" method="POST" action="<c:url value='/cart/remove/${item.value.book.bookId}'/>">
					<input type="hidden" name="_method" value="PUT"/>
					<c:forEach items="${cart.cartItems}" var="item">
					<tr>
						<td>${item.value.book.bookId}-${item.value.book.name}</td>
						<td>${item.value.book.unitPrice}</td>
						<td>${item.value.quantity}</td>
						<td>${item.value.totalPrice}</td>
						<td><a href="javascript:removeFromCart('../cart/remove/${item.value.book.bookId}')" class="badge badge-danger">삭제</a></td>
					</tr>
					</c:forEach>
				</form:form>
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th>${cart.grandTotal}</th>
					<th></th>
				</tr>
			</table>
			<a href="<c:url value="/books"/>" class="btn btn-secondary">&laquo; 쇼핑 계속하기</a>
		</div>
	</div>
</body>
</html>