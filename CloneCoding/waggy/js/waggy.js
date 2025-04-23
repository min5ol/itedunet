// 드롭다운

document.querySelector('.drop-btn').onclick = (e) => {
  e.stopPropagation();
  document.querySelector('.dropdown').classList.toggle('show');
};

window.onclick = () => {
  document.querySelector('.dropdown').classList.remove('show');
};

// 슬라이드

const slides = document.querySelectorAll('.slide');
const dots = document.querySelectorAll('.dot');

let current = 0;

function showSlide(i) {
  slides.forEach(s => s.classList.remove('active'));
  dots.forEach(d => d.classList.remove('active'));
  slides[i].classList.add('active');
  dots[i].classList.add('active');
}

dots.forEach((dot, i) => {
  dot.addEventListener('click',() => {
    current = i;
    showSlide(i);
  });
});

setInterval(() => {
  current = (current + 1) % slides.length;
  showSlide(current);
}, 4000);

// 탭

const tabBtns = document.querySelectorAll(".tab-btn");
const tabContents = document.querySelectorAll(".tab-content");

tabBtns.forEach(btn => {
  btn.addEventListener('click', () => {
    const target = btn.dataset.tab;
    tabBtns.forEach(b => b.classList.remove('active'));
    tabContents.forEach(c => c.style.display = 'none');
    btn.classList.add('active');
    document.getElementById(target).style.display ='block';
  })
})