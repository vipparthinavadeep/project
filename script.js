/* ========================= */
/* PATHFINDER ADVANCED JS */
/* ========================= */

document.addEventListener("DOMContentLoaded", function(){

/* Scroll Reveal */

const reveals = document.querySelectorAll(".card, .course-card");

function revealOnScroll(){
const windowHeight = window.innerHeight;

reveals.forEach(el=>{
const elementTop = el.getBoundingClientRect().top;

if(elementTop < windowHeight - 50){
el.classList.add("active");
}
});
}

window.addEventListener("scroll", revealOnScroll);


/* Navbar active link */

const links = document.querySelectorAll("nav a");
const currentPage = window.location.pathname.split("/").pop();

links.forEach(link=>{
if(link.getAttribute("href") === currentPage){
link.classList.add("active");
}
});


/* Card click animation */

const cards = document.querySelectorAll(".card");

cards.forEach(card=>{
card.addEventListener("click",()=>{
card.style.transform="scale(0.95)";
setTimeout(()=>{
card.style.transform="";
},150);
});
});


/* Smooth button hover */

const buttons = document.querySelectorAll(".btn");

buttons.forEach(btn=>{
btn.addEventListener("mouseenter",()=>{
btn.style.transform="translateY(-5px)";
});
btn.addEventListener("mouseleave",()=>{
btn.style.transform="translateY(0)";
});
});

});