let input = document.getElementById("filter");
let listItems = document.querySelectorAll("ul li");

input.addEventListener("input", function(){
  let keyword = input.value;

  listItems.forEach(function (item) {
    let text = item.textContent;
    if (text.includes(keyword)) {
      item.style.display = "block";
    }
    else {
      item.style.display = "none";
    }
  })
})