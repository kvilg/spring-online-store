package com.example.demo.controllers;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controllers.repositori.*;

import java.util.Objects;

@RestController
public class GetProd {


    @Autowired
    private GitarRepo giarData;

    @Autowired
    private HeadphonesRepo headphonesData;

    @Autowired
    private KeyboardsRepo keyboardsData;

    @Autowired
    private MicrophonesRepo microphonesData;

    @Autowired
    private PercussionRepo percussionData;

    @Autowired
    private StudioEquipmentRepo studioEquipmentData;

    @GetMapping("/getListProd/{id}/{type}")
    public String getProd(@PathVariable(value = "id") Integer id,
                          @PathVariable(value = "type") String type){

        if (Objects.equals(type, "gitar")){
            Gitar prod = giarData.findByIdProduct(id).get(0);

            return "<div class=\"price\">" +
                    + prod.getPrice() +
                    "</div>" +"<br>"+
                    "<div class=\"text\">"
                    + prod.getName()+"<br>"+ prod.getSensors()+"<br>"+prod.getType()  +
                    "</div>";

        }

        if (Objects.equals(type, "headphones")){
            Headphones prod = headphonesData.findByIdProduct(id).get(0);


            return "<div class=\"price\">" +
                    + prod.getPrice() +
                    "</div>" +"<br>"+
                    "<div class=\"text\">"
                    + prod.getName()+"<br>"+prod.getType()  +
                    "</div>";

        }

        if (Objects.equals(type, "keyboards")){
            Keyboards prod = keyboardsData.findByIdProduct(id).get(0);

            return "<div class=\"price\">" +
                    + prod.getPrice() +
                    "</div>" +"<br>"+
                    "<div class=\"text\">"
                    + prod.getName() +"<br>"+prod.getMidi()+"<br>"+prod.getType()  +
                    "</div>";


        }

        if (Objects.equals(type, "microphones")){
            Microphones prod = microphonesData.findByIdProduct(id).get(0);

            return "<div class=\"price\">" +
                    + prod.getPrice() +
                    "</div>" +"<br>"+
                    "<div class=\"text\">"
                    + prod.getName() +"<br>"+prod.getOrientation()+"<br>"+prod.getType()  +
                    "</div>";


        }

        if (Objects.equals(type, "percussion")){
            Percussion prod = percussionData.findByIdProduct(id).get(0);


            return "<div class=\"price\">" +
                    + prod.getPrice() +
                    "</div>" +"<br>"+
                    "<div class=\"text\">"
                    + prod.getName() +"<br>"+prod.getModel()+"<br>"+prod.getType()  +
                    "</div>";


        }

        if (Objects.equals(type, "studio_equipment")){
            StudioEquipment prod = studioEquipmentData.findByIdProduct(id).get(0);



            return "<div class=\"price\">" +
                    + prod.getPrice() +
                    "</div>" +"<br>"+
                    "<div class=\"text\">"
                    + prod.getName() +"<br>"+prod.getInLine()+"<br>"+prod.getOutLine()  +
                    "</div>";


        }


        return "";
    }



}
