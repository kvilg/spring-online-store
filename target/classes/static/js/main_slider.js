const mainSliderContainer = document.querySelector('.main_slider_container');


const btn1 = document.getElementById("msin_slider_dtn_1");
const btn2 = document.getElementById("msin_slider_dtn_2");
const btn3 = document.getElementById("msin_slider_dtn_3");
const btn4 = document.getElementById("msin_slider_dtn_4");

const itemMainSlider = document.querySelector('.main_slider_item');

const slidesToShowMainSlider = 1;

let widthMainSlider = mainSliderContainer.clientWidth;

let itemArrMainSlider = document.querySelectorAll('.main_slider_item');
let moveMainSlider = document.querySelector('.main_slider_move');

//transform: translateX(-400px);

let posMainSlider = 0;


btn1.addEventListener('click', () => {

    posMainSlider = 1;
    setPosMainSlider();

});
btn2.addEventListener('click', () => {
    posMainSlider = 2;
    setPosMainSlider();

});
btn3.addEventListener('click', () => {
    posMainSlider = 3;
    setPosMainSlider();

});
btn4.addEventListener('click', () => {
    posMainSlider = 4;
    setPosMainSlider();

});

const setPosMainSlider = () => {
    moveMainSlider.style.transform = 'translateX(' + ((posMainSlider - 1) * -widthMainSlider) + 'px)';
};