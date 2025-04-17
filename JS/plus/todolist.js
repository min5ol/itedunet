let count = 0; // 홀수 짝수 배경색을 다르게 지정하기 위한 숫자형 변수 생성

function addTodo(){
  let todo = document.querySelector("input"); // 인풋의 value값을 뽑기 위한 변수
  let todoText = todo.value.trim(); // 인풋의 value 값과 공백 제거까지 마친 변수

  if (todoText !== "") { // 인풋의 값이 빈값이 아닐 때
    let newItem = document.createElement("p"); // p태그를 생성하는 변수를 만들고
    newItem.classList.add("item"); // 그 클래스 네임은 item이다.
    newItem.textContent = todoText; // 인풋의 밸류값을 p태그 안에 텍스트 내용만 집어넣는다.

    newItem.classList.add(count % 2 === 0 ? "even" : "odd"); // 홀수와 짝수를 구분하여 even 혹은 odd 라는 클래스를 준다.

    let delBtn = document.createElement("button"); // 버튼을 생성한다 
    delBtn.textContent = "❌"; // 그 버튼의 내용은 X 이다.
    delBtn.classList.add("delete-btn"); // 그 버튼의 클래스명을 준다

    // 그 버튼을 클릭 시 newItem 이라는 요소가 삭제된다.
    delBtn.onclick = function () {
      newItem.remove();
    };

    // newItem 이라는 요소에 삭제버튼을 추가한다.
    newItem.appendChild(delBtn);

    // 투두아웃풋 요소에 뉴아이템을 추가한다
    document.querySelector("#todo-output").appendChild(newItem);

    // 초기화
    todo.value="";
    count++;
  }
}
