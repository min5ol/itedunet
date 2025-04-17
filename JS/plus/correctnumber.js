let correct = Math.floor(Math.random() * 100) + 1;
let numInput = document.querySelector("#number");
let result = document.querySelector("#result");
let count = 0;

function correctNumber() {
  let num = Number(numInput.value);
  count ++;

  if(num < 1 || num > 100) {
    result.innerHTML = `1과 100 사이의 숫자를 입력하세요.`;
  }
  else if(num > correct) {
    result.innerHTML = `${num} 보다 낮은 숫자입니다. 다시 시도해 보세요.`;
  }
  else if(num < correct) {
    result.innerHTML = `${num} 보다 높은 숫자입니다. 다시 시도해 보세요.`;
  }
  else {
    result.innerHTML = `정답입니다! ${count}번 만에 맞췄습니다. 축하합니다.`
    correct = Math.floor(Math.random() * 100) + 1;
  }
}