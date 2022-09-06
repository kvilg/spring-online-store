function startProduct() {
    

    const GITminPrise = document.getElementById('input_text1');
    const GITmaxPrise = document.getElementById('input_text2');

    var xhr = new XMLHttpRequest();

    const elTempEl = document.querySelector('.getElForTemp');
    
    xhr.open('GET', '/get_start/'+elTempEl.id, false);


    xhr.send();



    //console.log(xhr.responseText);
    createGitar(xhr.responseText,1);
    createSachDiv(xhr.responseText);
    sutheBtnActiv();
    

}
startProduct();