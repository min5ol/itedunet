let btn = document.querySelector(".top-dropbtn");
let menu = document.querySelector(".top-dropdown-content");

btn.addEventListener("click", function () {
  menu.classList.toggle("show");
});

window.addEventListener("click", function (e) {
  if (!e.target.matches(".top-dropbtn") && !e.target.closest(".top-dropdown")) {
    menu.classList.remove("show");
  }
});


// 슬라이더 전체 감싸는 요소(.slides) 선택
const slides = document.querySelector(".slides");

// 하단 도트(인디케이터) 버튼 모두 선택
const dots = document.querySelectorAll(".dot");

// 총 슬라이드 개수 (복제 포함: 앞 1개, 뒤 1개 → 총 5개)
const total = 5;

// 현재 보여지는 슬라이드 인덱스 (시작은 실제 1번이니까 index 1)
let current = 1;

// 첫 시작 시 슬라이드 위치 설정 (첫 번째 실제 슬라이드 보이게)
slides.style.transform = `translateX(-${current * 100}vw)`;

// 슬라이드를 특정 인덱스로 이동시키는 함수
function moveToSlide(index) {
  // 1. 부드러운 애니메이션 적용
  slides.style.transition = "transform 0.6s ease";

  // 2. 슬라이드 위치를 index에 맞춰 이동
  slides.style.transform = `translateX(-${index * 100}vw)`;

  // 3. 현재 인덱스 저장
  current = index;

  // 4. 모든 도트에서 'active' 클래스 제거
  dots.forEach(dot => dot.classList.remove("active"));

  // 5. 현재 위치에 해당하는 도트에만 'active' 클래스 추가
  // (복제 슬라이드는 제외하고, 실제 슬라이드에만 표시되게 index-1로 처리)
  dots[(index - 1 + dots.length) % dots.length].classList.add("active");
}

// 도트 클릭 시 해당 슬라이드로 이동시키는 이벤트 연결
dots.forEach((dot, index) => {
  dot.addEventListener("click", () => {
    // index는 0부터 시작이므로 실제 슬라이드는 index + 1
    moveToSlide(index + 1);
  });
});

// 무한 슬라이드 구현: transition 끝났을 때 위치 점프 처리
slides.addEventListener("transitionend", () => {
  // 만약 0번 인덱스(복제된 마지막 슬라이드)를 본 경우
  if (current === 0) {
    // 1. 트랜지션 없이 순간이동으로 진짜 마지막 슬라이드로 점프
    slides.style.transition = "none";
    slides.style.transform = `translateX(-300vw)`;

    // 2. 현재 인덱스도 진짜 마지막(3)으로 갱신
    current = 3;
  }

  // 만약 마지막 인덱스(복제된 첫 번째 슬라이드)를 본 경우
  if (current === total - 1) {
    // 1. 트랜지션 없이 첫 번째 진짜 슬라이드로 순간이동
    slides.style.transition = "none";
    slides.style.transform = `translateX(-100vw)`;

    // 2. 현재 인덱스를 진짜 첫 번째(1)로 갱신
    current = 1;
  }
});

// 자동으로 슬라이드가 3초마다 한 칸씩 넘어가도록 설정
setInterval(() => {
  // 현재 인덱스에서 +1 → 다음 슬라이드로 이동
  // 무한 루프니까 마지막 슬라이드(복제) 이후엔 다시 첫 번째로 점프됨
  moveToSlide(current + 1);
}, 3000); // 3초마다 슬라이드 전환
