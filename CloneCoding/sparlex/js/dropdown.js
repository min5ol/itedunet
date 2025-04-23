document.querySelector('.drop-btn').onclick = (e) => {
  e.stopPropagation();
  document.querySelector('.dropdown').classList.toggle('show');
};

window.onclick = () => {
  document.querySelector('.dropdown').classList.remove('show');
};