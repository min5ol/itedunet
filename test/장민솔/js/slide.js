const slides = document.querySelectorAll('.slide');
const prev = document.querySelector('.prev');
const next = document.querySelector('.next');

let index = 0;

const showSlide = () => {
  document.querySelector('.slides').style.transform = `translateX(-${index * 100}vw)`;
}

next.onclick = () => {
  index = (index + 1) % slides.length;
  showSlide();
}

prev.onclick = () => {
  index = (index - 1 + slides.length) % slides.length;
  showSlide();
}

showSlide();