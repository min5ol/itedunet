let colors = ["green", "red", "rgba(133,122,200,0.8)", "#f15025"];
let colorName = document.querySelector("#color");
let bg = document.querySelector("#main");
let current = 0;

function changeBG() {
    colorName.innerHTML = colors[current];
    colorName.style.color = colors[current];
    bg.style.backgroundColor = colors[current];
    
    current++

    if (current >= colors.length) {
      current = 0;
    }
}