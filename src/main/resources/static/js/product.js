



const idProd = document.querySelector('.idProd');





reqImgHttpForProd(idProd);


reqHttpProd();

function reqImgHttpForProd(item){
    
    var xhr = new XMLHttpRequest();

    xhr.open('GET', '/getImg/'+item.id+'/true', false);
    
    xhr.send();
    
   console.log(item.querySelector('.product_img_slid'));
    
    var image = new Image();
    image.onload = function(){
       console.log(image.width); // image is loaded and we have image width 
    }

    console.log( xhr.responseText)
    
    document.querySelector('.product_img_slid_src').src =  xhr.responseText;
}

function reqHttpProd(){
    
    const idProd = document.querySelector('.idProd');
    const typeProd = document.querySelector('.typeProd');

    var xhr = new XMLHttpRequest();

    xhr.open('GET', '/getListProd/'+idProd.id+'/'+typeProd.id, false);
    
    xhr.send();

    console.log(xhr.responseText);
    
    const product_price = document.querySelector('.product_price');


    product_price.innerHTML = xhr.responseText;


}




