let herName = "SYAHMIZAR ❤️";
let correctPassword = "07-12-2024";

// PASSWORD
function checkPassword() {
    let input = document.getElementById("password").value;

    if (input === correctPassword) {
        document.getElementById("lockscreen").style.display = "none";
        document.getElementById("mainContent").classList.remove("hidden");

        document.getElementById("bigName").innerHTML = herName;
        document.getElementById("bgMusic").play();
        typeWriter();
        confetti({ particleCount: 200, spread: 120 });
    } else {
        document.getElementById("error").innerHTML = "Yaahh salah muuyyy😢";
    }
}

// COUNTDOWN
let birthday = new Date("Dec 15, 2026 00:00:00").getTime();

setInterval(function() {
    let now = new Date().getTime();
    let distance = birthday - now;

    let hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    let minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    let seconds = Math.floor((distance % (1000 * 60)) / 1000);

    document.getElementById("countdown").innerHTML =
        "Menuju jam 00:00: " + hours + "j "
        + minutes + "m " + seconds + "d ";

    if (distance < 0) {
        confetti({ particleCount: 300, spread: 150 });
    }
}, 1000);

// TYPING EFFECT
let text = "Amuuuyyyy, terimaaaa kasiiiiiih sudaaaah hadiiiir di hidupp aannn. amuuuuyyyy adalah alasannnn aannnn tersenyuuuuum setiaaaap haaariii. aannnn haaaarap bisaaaaa teruuuuus samaaaaa amuuuuuyyyyy, selamanya lamanyaaaaa ❤️";
let i = 0;

function typeWriter() {
    if (i < text.length) {
        document.getElementById("typingText").innerHTML += text.charAt(i);
        i++;
        setTimeout(typeWriter, 50);
    }
}

// SURPRISE
function showSurprise() {document.getElementById("voiceNote").play();

    document.getElementById("surprise").classList.toggle("hidden");
    confetti({ particleCount: 200, spread: 100 });

    if (navigator.vibrate) {
        navigator.vibrate(300);
    }
}

// HEART EFFECT
function createHeart() {
    let heart = document.createElement("div");
    heart.className = "heart";
    heart.innerHTML = "❤️";
    heart.style.left = Math.random() * 100 + "vw";
    document.body.appendChild(heart);

    setTimeout(() => {
        heart.remove();
    }, 5000);
}

setInterval(createHeart, 500);

// AUTO SLIDESHOW
let slides = document.querySelectorAll(".slide");
let currentSlide = 0;

function showNextSlide() {
    slides[currentSlide].classList.remove("active");

    currentSlide++;
    if (currentSlide >= slides.length) {
        currentSlide = 0;
    }

    slides[currentSlide].classList.add("active");
}

setInterval(showNextSlide, 4000);

// DOT INDICATOR
const slider = document.getElementById("slider");
const images = document.querySelectorAll(".slides img");
const dotsContainer = document.getElementById("dots");

let currentIndex = 0;

// buat dots otomatis sesuai jumlah foto
images.forEach((_, index) => {
    let dot = document.createElement("div");
    dot.classList.add("dot");
    if (index === 0) dot.classList.add("active");
    dotsContainer.appendChild(dot);
});

const dots = document.querySelectorAll(".dot");

slider.addEventListener("scroll", () => {
    const slideWidth = slider.offsetWidth;
    const index = Math.round(slider.scrollLeft / slideWidth);

    if (index !== currentIndex) {
        dots[currentIndex].classList.remove("active");
        dots[index].classList.add("active");
        currentIndex = index;
    }
});


