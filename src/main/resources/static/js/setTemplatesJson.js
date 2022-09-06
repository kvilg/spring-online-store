
function createGitar(txt , namIn) {
    const mainP = document.getElementById('inNewParam');
    const type = document.querySelector('.getElForTemp');
    //console.log(txt);

    let obj = JSON.parse(txt);

    namI =namIn * 5;
    
    let strHtml = ``;

    //console.log(namI-5);
    //console.log(namI);

    //obj.git.length
    try{
        for(i = +(namI-5) ; i<+namI ; i++){
            if(i<obj.git.length){
                strHtml +=   `<div class="product_i">
                    <div class="product_info">
                        <div class="product_name">
                            `+obj.git[i].nameGit+`
                        </div>
                        <div class="product_price">
                            `+obj.git[i].priceGit+`
                        </div>
                        <div class="product_type">
                            `+obj.git[i].sensorsGit+`
                        </div>
                        <div class="product_sens">
                            `+obj.git[i].typeGit+`
                        </div>

                        <a href="/getProduct/`+obj.git[i].idProd+`/`+type.id+`"><button class="btn_new_templats_product" >открыть страницу с товаром</button></a>

           

                        </div>
                        <div class="product_img" id="`+obj.git[i].idProd+`" >
                            <img src=""class="product_img_wid">
                        </div>

                    </div>`;
            }   
        }


    }catch{

    }

    mainP.innerHTML = strHtml;



    postImgObserv();







    const btnSut = document.getElementById('product_next');


    let strHtmlNew = ``;



    

    iMin = +namIn-5;
  


    if(iMin <= 0){
        plassMax = iMin*(-1);
        iMin = 1
    }else{
        plassMax = 0;
    }
  


    iMax = +namIn + 5 + plassMax;
   
    if(iMax > Math.ceil(+((obj.git.length)/5))){
        minusMin = iMax - Math.ceil(+((obj.git.length)/5));
        iMax = Math.ceil(+((obj.git.length)/5));
        if(iMin<1){
            iMin = iMin - minusMin;
        }
       
    }







    strHtmlNew +=`<div class="btn_nam_next_l" id="next_param_l"></div>`;



    if(iMin != 1){
        strHtmlNew += `  <div class="nam_next" id="next_param">`+1+`</div>`;
        if(iMin == 2){
            iMin =3
        }
        strHtmlNew += `<div class="non_nam_next">...</div>`;
    }

    if(iMax == Math.ceil(+((obj.git.length)/5))-1){
        iMax = Math.ceil(+((obj.git.length)/5))-2;
    }

    for(i = iMin ; i <= iMax ; i++){
        if(+namIn == i){
            strHtmlNew += `  <div class="nam_next aktiv" id="next_param">`+i+`</div>`;
        }else{
            strHtmlNew += `  <div class="nam_next" id="next_param">`+i+`</div>`;
        }
    }



    if(iMax != Math.ceil(+((obj.git.length)/5))){
        strHtmlNew += `<div class="non_nam_next">...</div>`;
        strHtmlNew +=`  <div class="nam_next" id="next_param">`+Math.ceil(+((obj.git.length)/5))+`</div>`;
    }



    strHtmlNew +=`<div class="btn_nam_next_r" id="next_param_r"></div>`;

    btnSut.innerHTML = strHtmlNew; 


    const nextArrAA = document.querySelectorAll('.nam_next');
    const next_param_l = document.getElementById('next_param_l');
    const next_param_r = document.getElementById('next_param_r');

    


   

    nextArrAA.forEach((next) => {
        next.addEventListener('click', () => {
            createGitar(txt,+(next.innerText));
        });
    });

    next_param_l.addEventListener('click', () => {
        if((+namIn) != 1){
            createGitar(txt,(+namIn)-1);
        }
        
    });
   
   
    next_param_r.addEventListener('click', () => {
        if((+namIn) != Math.ceil(+((obj.git.length)/5))){
            createGitar(txt,(+namIn)+1);
        }
    });


}



function createSachDiv(txt) {

    const mainP = document.getElementById('disp_flex_slider');

    let obj = JSON.parse(txt);

    let minObj = obj.git[0].priceGit;
    let maxObj = 0;

    for (let i = 0; i < obj.git.length; i++) {
        if (maxObj<obj.git[i].priceGit) {
            maxObj = obj.git[i].priceGit;
        }
        if (minObj>obj.git[i].priceGit) {
            minObj = obj.git[i].priceGit;
        }
    
    }


    const elTemp = document.querySelector('.getElForTemp');
    

    
    

    let strSth = ``;

    if(elTemp.id == "gitar"){
        strSth =  
        `
        <div class="box_sahc_y">
            <div class="dox_flex ">
                <input type="checkbox" id="gitarAkustic" value="Akustic">
                <span>акустическая</span>
            </div>
            <div class="dox_flex ">
                <input type="checkbox" id="gitarElectro">
                <span>электро</span>
            </div>
            <div class="dox_flex">
                <input type="checkbox" id="gitarElectroAkustic">
                <span>электро-акустика</span>
            </div>
        </div>
        <div class="box_sahc_y">
            <div class="dox_flex ">
                <input type="checkbox" id="gitarAktivSens">
                <span>активные датчики</span>
            </div>
            <div class="dox_flex ">
                <input type="checkbox" id="gitarPassivSens">
                <span>пасивные датчики</span>
            </div>
        </div>
        `;
    }

    if(elTemp.id == "headphones"){
        strSth =  
        `
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="vnutriCanal">
                <span>внутриканальные</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="dinamicClose">
                <span> динамические закрытые </span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="close">
                <span> закрытые </span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="open">
                <span> открытые </span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="openPolu">
                <span> полуоткрытые </span>
            </div>
        </div>
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="provod">
                <span>Проводные</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="notProvod">
                <span>Без проводные</span>
            </div>
        </div>
        `;
    }

    if(elTemp.id == "keyboards"){
        strSth =  
        `
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="fortePiano">
                <span>форте-пиано</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="elektroPiano">
                <span>электро-пиано</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="sentezator">
                <span>сентезатор</span>
            </div>
        </div>
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="oktav5">
                <span>5 - актавные</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="oktav7">
                <span>7 - актавные</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="oktav23">
                <span>2-3 - актавные</span>
            </div>
        </div>
        `;
    }

    if(elTemp.id == "microphones"){
        strSth =  
        `
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="dinamic">
                <span>динамический</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="condensatorn">
                <span>конденсаторный</span>
            </div>
            
        </div>
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="izmenaema">
                <span>направленость - изменяемая</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="kardia">
                <span>направленость - кардиоида</span>
            </div>
        
        </div>
        `;
    }

    if(elTemp.id == "percussion"){
        strSth =  
        `
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="akustic">
                <span>акустическая</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="elektro">
                <span>электро</span>
            </div>
        </div>
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="sm104">
                <span>звуковой модуль sm104</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="sm110">
                <span>звуковой модуль sm110</span>
            </div>
        </div>
        `;
    }

    if(elTemp.id == "studio_equipment"){
        strSth =  
        `
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="1_5_in">
                <span>1-5 входов</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="6_10_in">
                <span>6-10 входов</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="11_15_in">
                <span>11-15 входов</span>
            </div>
            
        </div>
        <div class="box_sahc_y">
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="1_5_out">
                <span>1-5 выходов</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="6_10_out">
                <span>6-10 выходов</span>
            </div>
            <div class="dox_flex marg_bott">
                <input type="checkbox" id="11_15_out">
                <span>11-15 выходов</span>
            </div>
        </div>
        `;
    }








    

    let strHtml = `  <div class="box_sahc">
    <input type="range" min="`+minObj+`" max="`+maxObj+`" value="`+minObj+`" class="slider" id="lower">
    <input type="range" min="`+minObj+`" max="`+maxObj+`" value="`+maxObj+`" class="slider" id="higher">

    <input type="text" id="input_text1" class="mt20" value="`+minObj+`">
    <input type="text" id="input_text2" class="mt20" value="`+maxObj+`">
    </div>

    

    `+strSth+`




    

    <div class="box_sahc_y">
        <div class="dox_flex" id="sathInPrice">
            <div class="div_strelca" id="div_strelca_ter"></div>
            <span class="div_strelca_txt">сортировка по цене</span>
        </div>
    </div>



`;

    mainP.innerHTML = strHtml; 

}