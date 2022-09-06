const leftBtn = document.querySelector('.discounts_slider_left');
const rightBtn = document.querySelector('.discounts_slider_right');
const lets = document.querySelector('.header_left');
const item = document.querySelector('.discounts_slider_item');
const container = document.querySelector('.discounts_slider_container');

const slidesToShow = 6;


let width = container.clientWidth / slidesToShow;

let itemArr = document.querySelectorAll('.discounts_slider_item');
let move = document.querySelector('.discounts_slider_move');
let pos = 0;
let nowPos = 0;
//transform: translateX(-400px);

itemArr.forEach((item) => {
    item.style.minWidth = `${width}px`;
});

//console.log(itemArr.length);

rightBtn.addEventListener('click', () => {

    if (nowPos != itemArr.length - (slidesToShow - 1)) {
        pos -= width;
        nowPos++;
    }

    setPos();
});

leftBtn.addEventListener('click', () => {
    if (nowPos != -1) {
        pos += width;
        nowPos--;
    }

    setPos();
});

const setPos = () => {
    move.style.transform = 'translateX(' + pos + 'px)';
};