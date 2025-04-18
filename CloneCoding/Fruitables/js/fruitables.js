// dropdown 
// const dropBtn = document.querySelector('.dropdown-btn');
// const menu = document.querySelector('.dropdown-content');

// dropBtn.addEventListener('click', (e) => {
//   e.stopPropagation();
//   menu.classList.toggle('show');
// });

// window.addEventListener('click', () => {
//   menu.classList.remove('show');
// })

// const navItems = document.querySelectorAll('.nav-item.dropdown');

// navItems.forEach(item => {
//   item.addEventListener('mouseenter', () => {
//     item.classList.add('hover');
//   });

//   item.addEventListener('mouseleave', () => {
//     item.classList.remove('hover');
//   });
// });

// slide
document.addEventListener("DOMContentLoaded", function() {
  const slides = document.querySelectorAll(".slide");
  const prevBtn = document.querySelector(".main-btn-left");
  const nextBtn = document.querySelector(".main-btn-right");

  let current = 0;

  const showSlide = (index) => {
    slides.forEach(slide => slide.classList.remove("active"));
    slides[index].classList.add("active");
  }

  const nextSlide = () => {
    current = (current + 1) % slides.length;
    showSlide(current);
  }

  const prevSlide = () => {
    current = (current - 1 + slides.length) % slides.length;
    showSlide(current);
  }

  nextBtn.addEventListener("click", nextSlide);
  prevBtn.addEventListener("click", prevSlide);

  setInterval(nextSlide, 4000);
});

// tabs-name active 

document.addEventListener("DOMContentLoaded", function() {
  const labels = document.querySelectorAll('.tab-btn');

  labels.forEach(label => {
    label.addEventListener('click', () => {
      labels.forEach(l => l.classList.remove('active'));
      label.classList.add('active');
    })
  })
});

// tab

document.addEventListener("DOMContentLoaded", () => {
  const tabBtns = document.querySelectorAll(".tab-btn");
  const contents = document.querySelectorAll(".tab-content");

  tabBtns.forEach((btn, index) => {
    btn.addEventListener("click", () => {
      tabBtns.forEach(b => b.classList.remove("active"));
      btn.classList.add("active");
      
      contents.forEach(c => c.classList.remove("active"));
      contents[index].classList.add("active");
    });
  });

  // 첫 탭 보여주기
  contents.forEach(c => c.classList.remove("active"));
  contents[0].classList.add("active");
});
