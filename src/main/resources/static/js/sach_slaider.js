function sutheBtnActiv() {
    

    const sliders = document.querySelectorAll('input[type="range"]');
    const div = document.getElementById('input_text1');
    const div1 = document.getElementById('input_text2');
    const carl = document.querySelector('.carl');
    const btn_sach_gitar = document.querySelector('.btn_sach_gitar');


    const minPrise = document.getElementById('input_text1');
    const maxPrise = document.getElementById('input_text2');

    const gitarAkustic = document.getElementById('gitarAkustic');
    const gitarElectro = document.getElementById('gitarElectro');
    const gitarElectroAkustic = document.getElementById('gitarElectroAkustic');

    const gitarAktivSens = document.getElementById('gitarAktivSens');
    const gitarPassivSens = document.getElementById('gitarPassivSens');


    const vnutriCanal = document.getElementById('vnutriCanal');
    const dinamicClose = document.getElementById('dinamicClose');
    const close = document.getElementById('close');
    const open = document.getElementById('open');
    const openPolu = document.getElementById('openPolu');

    const provod = document.getElementById('provod');
    const notProvod = document.getElementById('notProvod');



    const fortePiano = document.getElementById('fortePiano');
    const elektroPiano = document.getElementById('elektroPiano');
    const sentezator = document.getElementById('sentezator');

    const oktav5 = document.getElementById('oktav5');
    const oktav7 = document.getElementById('oktav7');
    const oktav23 = document.getElementById('oktav23');





    const dinamic = document.getElementById('dinamic');
    const condensatorn = document.getElementById('condensatorn');

    const izmenaema = document.getElementById('izmenaema');
    const kardia = document.getElementById('kardia');



    const akustic = document.getElementById('akustic');
    const elektro = document.getElementById('elektro');

    const sm104 = document.getElementById('sm104');
    const sm110 = document.getElementById('sm110');

    


    const in_5 = document.getElementById('1_5_in');
    const in_10 = document.getElementById('6_10_in');
    const in_15 = document.getElementById('11_15_in');
    
    const out_5 = document.getElementById('1_5_out');
    const out_10 = document.getElementById('6_10_out');
    const out_15 = document.getElementById('11_15_out');











    const sathInPrice = document.getElementById('sathInPrice');
    const div_strelca_ter = document.getElementById('div_strelca_ter');
    let sathInPriceBtn = 'up';

    let jsonAllG ;

    sliders[0].addEventListener('input', (e) => {
        if (+sliders[0].value + 200 > +sliders[1].value) {
            sliders[1].value = +sliders[0].value + 20000;
        }
    });

    sliders[1].addEventListener('input', (e) => {
        if (+sliders[1].value - 200 < +sliders[0].value) {
            sliders[0].value = +sliders[1].value - 20000;
        }
    });

    sliders.forEach((slider) => {
        slider.addEventListener('input', () => {
            div.value = `${sliders[0].value}`;
            div1.value = `${sliders[1].value}`;
        })
    });


    minPrise.addEventListener('change', () => {
        sliders[0].value = minPrise;
    });

    maxPrise.addEventListener('change', () => {
        sliders[1].value = maxPrise;
    });

    

    sathInPrice.addEventListener('click', () => {
        if(sathInPriceBtn == 'daun'){
            div_strelca_ter.style.transform = "rotate(135deg)";
            sathInPriceBtn = 'up';
            console.log('up');
        }else{
            sathInPriceBtn = 'daun';
            div_strelca_ter.style.transform = "rotate(-45deg)";
            console.log('daun');
        }
    });



    btn_sach_gitar.addEventListener('click', () => {
        

        var xhr = new XMLHttpRequest();

        let typeArr = [];
        
        let sensorsArr = [];

        
        try{

            if(gitarAkustic.checked){
                typeArr.push("акустическа");
            }
            if(gitarElectro.checked){
                typeArr.push("электро");
            }
            if(gitarElectroAkustic.checked){
                typeArr.push("электро-акустика");
            }

        }catch{

        } 

        try{  

            if(vnutriCanal.checked){
                typeArr.push("внутриканальные");
            } 
            if(dinamicClose.checked){
                typeArr.push("динамические закрытые");
            } 
            if(close.checked){
                typeArr.push("закрытые");
            } 
            if(open.checked){
                typeArr.push("открытые");
            } 
            if(openPolu.checked){
                typeArr.push("полуоткрытые");
            }
        }catch{

        }

        try{
            if(fortePiano.checked){
                typeArr.push("форте-пиано");
            } 
            if(elektroPiano.checked){
                typeArr.push("электро-пиано");
            } 
            if(sentezator.checked){
                typeArr.push("сентезатор");
            } 
        }catch{

        }


        try {
            if(dinamic.checked){
                typeArr.push("динамический");
            } 
            if(condensatorn.checked){
                typeArr.push("конденсаторный");
            } 
        } catch  {
            
        }
      
    
        try {
            if(akustic.checked){
                sensorsArr.push("акустическая");
            } 
            if(elektro.checked){
                sensorsArr.push("электро");
            }
        } catch {
            
        }
    
      
    
        


       

        try{
            if(gitarAktivSens.checked){
                sensorsArr.push("активные");
            }
            if(gitarPassivSens.checked){
                sensorsArr.push("пасивные");
            }
        }catch{

        }






        try{
            if(provod.checked){
                sensorsArr.push("1");
            }
            if(notProvod.checked){
                sensorsArr.push("0");
            }
        }catch{

        }

       
        try {



            if(oktav5.checked){
                sensorsArr.push("5");
            }
            if(oktav7.checked){
                sensorsArr.push("7");
            }
            if(oktav23.checked){
                sensorsArr.push("2");
                sensorsArr.push("3");
            }
         

            
        } catch  {
            
        }

        try {
            if(izmenaema.checked){
                sensorsArr.push("изменяемая");
            }
            if(kardia.checked){
                sensorsArr.push("кардиоида");
            }
        } catch  {
            
        }
        

        try {
            if(sm104.checked){
                typeArr.push("sm104");
            }
            if(sm110.checked){
                typeArr.push("sm110");
            }
        } catch {
            
        }


        try {
            if(out_5.checked){
                typeArr.push(1);
                typeArr.push(2);
                typeArr.push(3);
                typeArr.push(4);
                typeArr.push(5);
            }
            if(out_10.checked){
                typeArr.push(6);
                typeArr.push(7);
                typeArr.push(8);
                typeArr.push(9);
                typeArr.push(10);
            }
            if(out_15.checked){
                
                typeArr.push(11);
                typeArr.push(12);
                typeArr.push(13);
                typeArr.push(14);
                typeArr.push(15);
            }
        } catch  {
            
        }


        try {
            if(in_5.checked){
                sensorsArr.push(1);
                sensorsArr.push(2);
                sensorsArr.push(3);
                sensorsArr.push(4);
                sensorsArr.push(5);
            }
            if(in_10.checked){
                sensorsArr.push(6);
                sensorsArr.push(7);
                sensorsArr.push(8);
                sensorsArr.push(9);
                sensorsArr.push(10);

            }
            if(in_15.checked){
                sensorsArr.push(11);
                sensorsArr.push(12);
                sensorsArr.push(13);
                sensorsArr.push(14);
                sensorsArr.push(15);
                
            }
        } catch  {
            
        }




        console.log(typeArr);
        console.log(sensorsArr);
    

        

        
        var json = JSON.stringify({
            priceMin: +minPrise.value,
            priceMax:  +maxPrise.value,
            typeGit: typeArr,
            sensorsGit:sensorsArr,
            sathInPrice:sathInPriceBtn
            
        });
        //console.log(json);

        const elTempEl = document.querySelector('.getElForTemp');

        xhr.open("POST", '/getProd/'+elTempEl.id, true);

        xhr.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
        xhr.send(json);

        xhr.onreadystatechange = function() {
            jsonAllG = xhr.responseText;
       

            createGitar(xhr.responseText,1);




        
    

        }
        
        
    });


}

