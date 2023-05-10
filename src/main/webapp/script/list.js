const carouselContainer = document.querySelector('.carousel-container');
const carouselSlides = carouselContainer.querySelectorAll('.carousel-slide');
const carouselPrevBtn = carouselContainer.querySelector('.carousel-prev');
const carouselNextBtn = carouselContainer.querySelector('.carousel-next');

let currentSlide = 0;

function showSlide(n) {
    carouselSlides[currentSlide].classList.remove('active');
    currentSlide = (n + carouselSlides.length) % carouselSlides.length;
    carouselSlides[currentSlide].classList.add('active');
}

function prevSlide() {
    showSlide(currentSlide - 1);
}

function nextSlide() {
    showSlide(currentSlide + 1);
}

carouselPrevBtn.addEventListener('click', prevSlide);
carouselNextBtn.addEventListener('click', nextSlide);
