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
	setTimeout(() =>
	{
		console.log("1초 후 reload()");
		window.location.reload();
	}, 100);
}

function deleteConfirm(id)
{
	if(confirm("삭제합니다!!")==true) location.href="./delete?id="+id;
	else return;
}

