package com.example.demo.controllers;


import com.example.demo.controllers.repositori.ImgRepo;
import com.example.demo.json_model.*;
import com.example.demo.model.Img;
import com.solidfire.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@RestController
public class ControllerImg {

    @Autowired
    private ImgRepo imgData;


    @GetMapping("/getImg/{idImg}/{mainImg}")
    public String getImg(@PathVariable(value = "idImg") String idImg,
                         @PathVariable(value = "mainImg") String mainImg) throws SQLException {




        Long idImgIn = Long.valueOf(idImg);

        String mainImgIn = "";

        if(Objects.equals(mainImg, "true")){
            mainImgIn = "1";
        }else if(Objects.equals(mainImg, "false")){
            mainImgIn = "0";
        }


        Gson gson = new Gson();


        ResImgPost gsonOut = new ResImgPost();

        //List<Img> imgList = imgData.findByIdImg(mainImg,idImg);
        List<Img> imgList = imgData.findAllByMain_imgAndId_product(1,1111);


        if(imgList.size() == 0){
            return "0";
        }else {
            Blob ListStrBlob = imgList.get(0).getImgBlob();


            byte[] bytes = ListStrBlob.getBytes(1l, (int) ListStrBlob.length());

            String str1 = new String(bytes);

            gsonOut.imgList.add(new DataImg(str1));

            return str1;
//        return "";
        }
    }

    @PostMapping("/postImg")
    public String postImg(@RequestBody String json) throws SQLException {

        System.out.println("\n\n\n\n\n\n\n\n\n");
        System.out.println(json);
        System.out.println("\n\n\n\n\n\n\n\n\n");

        Gson gson = new Gson();
        ImgJsonPost gitImg = gson.fromJson(json, ImgJsonPost.class);

        ResImgPost gsonOut = new ResImgPost();


        byte[] byteData = gitImg.imgBlob.getBytes();

        Blob docInBlob = new SerialBlob(byteData);
        try {
            Img img = new Img();
            img.setMainImg(gitImg.mainImg);
            img.setIdProduct(gitImg.idProduct);
            img.setImgBlob(docInBlob);
            imgData.save(img);

            gsonOut.statusReq="OK";


            String jsonOut = gson.toJson(gsonOut);

            return jsonOut;
        }catch(Exception e){
            gsonOut.statusReq="NO";
            gsonOut.err = e.toString();
            String jsonOut = gson.toJson(gsonOut);
            return jsonOut;
        }
    }


}