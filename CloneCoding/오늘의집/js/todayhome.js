// 드롭다운 1
document.querySelector(".dropdown-btn").onclick = e => {
  e.stopPropagation();
  document.querySelector('.dropdown-contents').classList.toggle('show');
};

// 드롭다운 2
document.querySelector(".nav-btn").onclick = e => {
  e.stopPropagation();
  document.querySelector('.nav-contents').classList.toggle('show');
};

// 드롭다운 외 영역 클릭 시 닫기
window.onclick = () => {
  document.querySelector('.dropdown-contents').classList.remove('show');
  document.querySelector('.nav-contents').classList.remove('show');
};

// 메뉴 색 바꾸기
const navLinks = document.querySelectorAll(".header-nav-name a"); // 여러 개니까 querySelectorAll

navLinks.forEach(link => {
  link.addEventListener("click", (e) => {
    navLinks.forEach(l => l.classList.remove("active"));
    e.target.classList.add("active");
  });
});

// 메뉴 호버, active 시 등장하게 하기

const links = document.querySelectorAll(".header-nav-name");
const communityNav = document.querySelector(".community-nav");
const shoppingNav = document.querySelector(".shopping-nav");
const interiorNav = document.querySelector(".interior-nav");

const navs = [communityNav, shoppingNav, interiorNav];

function hideAllNavs() {
  navs.forEach(nav => nav.style.display = "none");
}

//hover 이벤트

links.forEach(link => {
  link.addEventListener("mouseenter", () => {
    hideAllNavs();
    if (link.textContent.includes("커뮤니티")) {
      communityNav.style.display = "block";
    } else if (link.textContent.includes("쇼핑")) {
      shoppingNav.style.display = "block";
    } else if (link.textContent.includes("인테리어")) {
      interiorNav.style.display = "block"
    }
  });
});