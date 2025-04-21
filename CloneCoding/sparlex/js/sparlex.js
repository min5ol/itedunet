document.querySelector('.dropdownbtn').onclick = (e) => {
  e.stopPropagation();
  document.querySelector('.dropdown').classList.toggle('show');
};

window.onclick = () => {
  document.querySelector('dropdown').classList.remove('show');
};