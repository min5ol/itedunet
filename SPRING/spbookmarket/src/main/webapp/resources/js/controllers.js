function addToCart(action)
{
	document.addForm.action = action;
	document.addForm.submit();
	alert("도서가 장바구니에 추가되었습니다!");
}

function removeFromCart(action)
{
	console.log("입장");
	console.log(action);
	document.removeForm.action = action;
	document.removeForm.submit();
	window.location.reload();
}
