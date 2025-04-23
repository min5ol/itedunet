const slides = document.querySelectorAll('.slide');
const next = document.querySelector('.next');
const prev = document.querySelector('.prev');
const dots = document.querySelectorAll('.dot');

let index = 0;

const showDots = () => {
  dots.forEach(dot => dot.classList.remove('active'));
  dots[index].classList.add('active');
};

const showSlide = () => {
  document.querySelector('.slides').style.transform = `translateX(-${index * 100}vw)`;
  showDots();
};

next.onclick = () => {
  index = (index + 1) % slides.length;
  showSlide();
};

prev.onclick = () => {
  index = (index - 1 + slides.length) % slides.length;
  showSlide();
};

dots.forEach((dot, i) => {
  dot.addEventListener('click', () => {
    index = i;
    showSlide();
  });
});

showSlide();