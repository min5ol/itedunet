// 메뉴 활성화 시 강조 표시 주기

let menuItems = document.querySelectorAll(".product-menu-item, .menu");

menuItems.forEach(item => {
  item.addEventListener("click", (e) => {
    e.preventDefault();

    menuItems.forEach(el => el.classList.remove("active"));

    item.classList.add("active");
  });
});

// 탭버튼 구현하기

const tabButtons = document.querySelectorAll('.product-menu-item');  // 탭 버튼들
const tabContents = document.querySelectorAll('.product-row-item'); // 탭 내용들

tabButtons.forEach(button => {
  button.addEventListener('click', () => {
    const tabId = button.dataset.tab;

    // 1. 모든 버튼에서 active 제거
    tabButtons.forEach(btn => btn.classList.remove('active'));

    // 2. 현재 누른 버튼만 active 추가
    button.classList.add('active');

    // 3. 모든 콘텐츠에서 active 제거
    tabContents.forEach(content => content.classList.remove('active'));

    // 4. id가 일치하는 콘텐츠에만 active 추가 + 상품 순차 애니메이션 실행
    const target = document.getElementById(tabId);
    if (target) {
      target.classList.add('active');

      // 5. 내부 상품들 하나씩 순차 등장 (화투패처럼!)
      const items = target.querySelectorAll('.product-item-block');
      items.forEach((item, idx) => {
        // 초기 상태로 되돌리기
        item.style.opacity = '0';
        item.style.transform = 'translateY(30px)';
        item.style.animation = 'none';

        // 약간의 시간차를 두고 애니메이션 적용
        setTimeout(() => {
          item.style.animation = 'fadeUp 0.5s ease forwards';
        }, idx * 100); // 0.1초 간격으로 순차적 등장
      });
    }
  });
});

window.addEventListener('scroll', () => {
  const header = document.querySelector('.wrap-menu-containor');
  if (window.scrollY > 50) {
    header.classList.add('scrolled');
  } else {
    header.classList.remove('scrolled');
  }
});

document.addEventListener("DOMContentLoaded", () => {
  const defaultTab = document.querySelector('#tab1');
  if (defaultTab) {
    const items = defaultTab.querySelectorAll('.product-item-block');
    items.forEach((item, idx) => {
      item.style.opacity = '0';
      item.style.transform = 'translateY(30px)';
      item.style.animation = 'none';
      setTimeout(() => {
        item.style.animation = 'fadeUp 0.5s ease forwards';
      }, idx * 100);
    });
  }
});