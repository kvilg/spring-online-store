function postImgObserv() {



    var targetAll = document.querySelectorAll('.product_img');
    
    let observer = new IntersectionObserver(function (entries, obs) {
        entries.forEach(function (entry) {
    // Если элемент в зоне видимости, то ничего не происходит
            if (!entry.isIntersecting) return;
    // Отключаем «наблюдатель»
            obs.unobserve(entry.target);

            reqImgHttp(entry.target);
            
        });
    });
    
    
   
    

    targetAll.forEach(el =>{
        observer.observe(el);
    })

    // Прикрепляем его к «наблюдателю»
   

        

}



function reqImgHttp(item){
    
    var xhr = new XMLHttpRequest();

    xhr.open('GET', '/getImg/'+item.id+'/true', false);
    
    xhr.send();
    
   console.log(item.querySelector('.product_img_wid'));
    
    var image = new Image();
    image.onload = function(){
       console.log(image.width); // image is loaded and we have image width 
    }
    
    item.querySelector('.product_img_wid').src =  xhr.responseText;
}
