package com.example.demo.controllers;




import com.example.demo.json_model.GitarJsonOut;
import com.example.demo.json_model.GitarSache;
import com.example.demo.model.*;
import com.example.demo.controllers.repositori.*;

import com.solidfire.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Objects;

@RestController
public class RestControllerIO {

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


    @GetMapping("/get_start/gitar")
    public String getGitarStart() {

        Gson gson = new Gson();

        List<Gitar> gitArr = null;

        gitArr = (List<Gitar>) giarData.findAll();

        GitarJsonOut gsonOut = new GitarJsonOut();

        for (int i = 0; i < gitArr.size(); i++) {
            Gitar g = gitArr.get(i);
            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),g.getSensors(),g.getIdProduct()));
        }

        String jsonOut = gson.toJson(gsonOut);

        return jsonOut;
    }




    @GetMapping("/get_start/percussion")
    public String getPercussionStart() {

        Gson gson = new Gson();

        List<Percussion> gitArr = null;

        gitArr = (List<Percussion>) percussionData.findAll();

        GitarJsonOut gsonOut = new GitarJsonOut();

        for (int i = 0; i < gitArr.size(); i++) {
            Percussion g = gitArr.get(i);
            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),g.getModel(),g.getIdProduct()));

        }

        String jsonOut = gson.toJson(gsonOut);

        return jsonOut;
    }

    @GetMapping("/get_start/keyboards")
    public String getKeyboardsStart() {

        Gson gson = new Gson();

        List<Keyboards> gitArr = null;

        gitArr = (List<Keyboards>) keyboardsData.findAll();

        GitarJsonOut gsonOut = new GitarJsonOut();

        for (int i = 0; i < gitArr.size(); i++) {
            Keyboards g = gitArr.get(i);
            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),g.getOctaves().toString()+"- октавная",g.getIdProduct()));
        }

        String jsonOut = gson.toJson(gsonOut);

        return jsonOut;
    }

    @GetMapping("/get_start/microphones")
    public String getMicrophonesStart() {

        Gson gson = new Gson();

        List<Microphones> gitArr = null;

        gitArr = (List<Microphones>) microphonesData.findAll();

        GitarJsonOut gsonOut = new GitarJsonOut();

        for (int i = 0; i < gitArr.size(); i++) {
            Microphones g = gitArr.get(i);
            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),g.getOrientation(),g.getIdProduct()));
        }

        String jsonOut = gson.toJson(gsonOut);

        return jsonOut;
    }

    @GetMapping("/get_start/headphones")
    public String getHeadphonesStart() {

        Gson gson = new Gson();

        List<Headphones> gitArr = null;

        gitArr = (List<Headphones>) headphonesData.findAll();

        GitarJsonOut gsonOut = new GitarJsonOut();

        for (int i = 0; i < gitArr.size(); i++) {
            Headphones g = gitArr.get(i);
            String midi = "";
            if(g.getWire()){
                midi = "проводные";
            }else {
                midi = "беспроводные";
            }


            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),midi,g.getIdProduct()));
        }

        String jsonOut = gson.toJson(gsonOut);

        return jsonOut;
    }

    @GetMapping("/get_start/studio_equipment")
    public String getStudioEquipmentStart() {

        Gson gson = new Gson();

        List<StudioEquipment> gitArr = null;

        gitArr = (List<StudioEquipment>) studioEquipmentData.findAll();

        GitarJsonOut gsonOut = new GitarJsonOut();

        for (int i = 0; i < gitArr.size(); i++) {
            StudioEquipment g = gitArr.get(i);
            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getInLine().toString()+" - количество входов",g.getOutLine().toString()+" - количество выходов",g.getIdProduct()));
        }

        String jsonOut = gson.toJson(gsonOut);

        return jsonOut;
    }




    @PostMapping("/getProd/gitar")
    public String getGitar(@RequestBody String json)  {



        Gson gson = new Gson();
        GitarSache git = gson.fromJson(json, GitarSache.class);
        List<Gitar> gitArr = null;
        //List<Gitar> gitArr = sql.getGitar(git.priceMin, git.priceMax, git.sensorsGit,git.typeGit);

        if(Objects.equals(git.sathInPrice, "up")) {
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = giarData.findByPriceUp(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = giarData.findByPriceAndSensorsUp(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = giarData.findByPriceAndSensorsAndTypeUp(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = giarData.findByPriceAndTypeUp(git.priceMin, git.priceMax, git.typeGit);
            }
        }else if(Objects.equals(git.sathInPrice, "daun")){
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = giarData.findByPriceDaun(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = giarData.findByPriceAndSensorsDaun(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = giarData.findByPriceAndSensorsAndTypeDaun(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = giarData.findByPriceAndTypeDaun(git.priceMin, git.priceMax, git.typeGit);
            }
        }




        GitarJsonOut gsonOut = new GitarJsonOut();

        for (int i = 0; i < gitArr.size(); i++) {
            Gitar g = gitArr.get(i);
            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),g.getSensors(),g.getIdProduct()));

        }




        String jsonOut = gson.toJson(gsonOut);



        return jsonOut;

    }

    @PostMapping("/getProd/headphones")
    public String getHeadphones(@RequestBody String json)  {



        Gson gson = new Gson();
        GitarSache git = gson.fromJson(json, GitarSache.class);
        List<Headphones> gitArr = null;
        //List<Gitar> gitArr = sql.getGitar(git.priceMin, git.priceMax, git.sensorsGit,git.typeGit);

        if(Objects.equals(git.sathInPrice, "up")) {
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = headphonesData.findByPriceUp(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = headphonesData.findByPriceAndSensorsUp(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = headphonesData.findByPriceAndSensorsAndTypeUp(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = headphonesData.findByPriceAndTypeUp(git.priceMin, git.priceMax, git.typeGit);
            }
        }else if(Objects.equals(git.sathInPrice, "daun")){
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = headphonesData.findByPriceDaun(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = headphonesData.findByPriceAndSensorsDaun(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = headphonesData.findByPriceAndSensorsAndTypeDaun(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = headphonesData.findByPriceAndTypeDaun(git.priceMin, git.priceMax, git.typeGit);
            }
        }




        GitarJsonOut gsonOut = new GitarJsonOut();



        for (int i = 0; i < gitArr.size(); i++) {
            Headphones g = gitArr.get(i);

            String midi = "";
            if(g.getWire()){
                midi = "проводные";
            }else {
                midi = "беспроводные";
            }

            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),midi,g.getIdProduct()));

        }




        String jsonOut = gson.toJson(gsonOut);



        return jsonOut;

    }





    @PostMapping("/getProd/keyboards")
    public String getKeyboards(@RequestBody String json)  {



        Gson gson = new Gson();
        GitarSache git = gson.fromJson(json, GitarSache.class);
        List<Keyboards> gitArr = null;
        //List<Gitar> gitArr = sql.getGitar(git.priceMin, git.priceMax, git.sensorsGit,git.typeGit);

        if(Objects.equals(git.sathInPrice, "up")) {
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = keyboardsData.findByPriceUp(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = keyboardsData.findByPriceAndSensorsUp(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = keyboardsData.findByPriceAndSensorsAndTypeUp(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = keyboardsData.findByPriceAndTypeUp(git.priceMin, git.priceMax, git.typeGit);
            }
        }else if(Objects.equals(git.sathInPrice, "daun")){
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = keyboardsData.findByPriceDaun(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = keyboardsData.findByPriceAndSensorsDaun(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = keyboardsData.findByPriceAndSensorsAndTypeDaun(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = keyboardsData.findByPriceAndTypeDaun(git.priceMin, git.priceMax, git.typeGit);
            }
        }




        GitarJsonOut gsonOut = new GitarJsonOut();



        for (int i = 0; i < gitArr.size(); i++) {
            Keyboards g = gitArr.get(i);



            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),g.getOctaves().toString()+"- октавная",g.getIdProduct()));

        }




        String jsonOut = gson.toJson(gsonOut);



        return jsonOut;

    }

    @PostMapping("/getProd/percussion")
    public String getPercussion(@RequestBody String json)  {



        Gson gson = new Gson();
        GitarSache git = gson.fromJson(json, GitarSache.class);
        List<Percussion> gitArr = null;
        //List<Gitar> gitArr = sql.getGitar(git.priceMin, git.priceMax, git.sensorsGit,git.typeGit);

        if(Objects.equals(git.sathInPrice, "up")) {
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = percussionData.findByPriceUp(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = percussionData.findByPriceAndSensorsUp(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = percussionData.findByPriceAndSensorsAndTypeUp(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = percussionData.findByPriceAndTypeUp(git.priceMin, git.priceMax, git.typeGit);
            }
        }else if(Objects.equals(git.sathInPrice, "daun")){
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = percussionData.findByPriceDaun(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = percussionData.findByPriceAndSensorsDaun(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = percussionData.findByPriceAndSensorsAndTypeDaun(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = percussionData.findByPriceAndTypeDaun(git.priceMin, git.priceMax, git.typeGit);
            }
        }




        GitarJsonOut gsonOut = new GitarJsonOut();



        for (int i = 0; i < gitArr.size(); i++) {
            Percussion g = gitArr.get(i);



            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),g.getModel(),g.getIdProduct()));

        }




        String jsonOut = gson.toJson(gsonOut);



        return jsonOut;

    }




    @PostMapping("/getProd/microphones")
    public String getMicrophones(@RequestBody String json)  {



        Gson gson = new Gson();
        GitarSache git = gson.fromJson(json, GitarSache.class);
        List<Microphones> gitArr = null;
        //List<Gitar> gitArr = sql.getGitar(git.priceMin, git.priceMax, git.sensorsGit,git.typeGit);

        if(Objects.equals(git.sathInPrice, "up")) {
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = microphonesData.findByPriceUp(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = microphonesData.findByPriceAndSensorsUp(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = microphonesData.findByPriceAndSensorsAndTypeUp(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = microphonesData.findByPriceAndTypeUp(git.priceMin, git.priceMax, git.typeGit);
            }
        }else if(Objects.equals(git.sathInPrice, "daun")){
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = microphonesData.findByPriceDaun(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = microphonesData.findByPriceAndSensorsDaun(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = microphonesData.findByPriceAndSensorsAndTypeDaun(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = microphonesData.findByPriceAndTypeDaun(git.priceMin, git.priceMax, git.typeGit);
            }
        }




        GitarJsonOut gsonOut = new GitarJsonOut();



        for (int i = 0; i < gitArr.size(); i++) {
            Microphones g = gitArr.get(i);



            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getType(),g.getOrientation(),g.getIdProduct()));

        }




        String jsonOut = gson.toJson(gsonOut);



        return jsonOut;

    }



    @PostMapping("/getProd/studio_equipment")
    public String getStudioEquipment(@RequestBody String json)  {



        Gson gson = new Gson();
        GitarSache git = gson.fromJson(json, GitarSache.class);
        List<StudioEquipment> gitArr = null;
        //List<Gitar> gitArr = sql.getGitar(git.priceMin, git.priceMax, git.sensorsGit,git.typeGit);



        

        if(Objects.equals(git.sathInPrice, "up")) {
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = studioEquipmentData.findByPriceUp(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = studioEquipmentData.findByPriceAndSensorsUp(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = studioEquipmentData.findByPriceAndSensorsAndTypeUp(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = studioEquipmentData.findByPriceAndTypeUp(git.priceMin, git.priceMax, git.typeGit);
            }
        }else if(Objects.equals(git.sathInPrice, "daun")){
            if (git.sensorsGit.size() == 0 && git.typeGit.size() == 0) {
                gitArr = studioEquipmentData.findByPriceDaun(git.priceMin, git.priceMax);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() == 0) {
                gitArr = studioEquipmentData.findByPriceAndSensorsDaun(git.priceMin, git.priceMax, git.sensorsGit);
            } else if (git.sensorsGit.size() != 0 && git.typeGit.size() != 0) {
                gitArr = studioEquipmentData.findByPriceAndSensorsAndTypeDaun(git.priceMin, git.priceMax, git.sensorsGit, git.typeGit);
            } else if (git.sensorsGit.size() == 0 && git.typeGit.size() != 0) {
                gitArr = studioEquipmentData.findByPriceAndTypeDaun(git.priceMin, git.priceMax, git.typeGit);
            }
        }


        


        GitarJsonOut gsonOut = new GitarJsonOut();



        for (int i = 0; i < gitArr.size(); i++) {
            StudioEquipment g = gitArr.get(i);


            



            gsonOut.git.add(new GitarJsonOut.GitarS(g.getName(),g.getPrice(),g.getInLine().toString()+" - количество входов",g.getOutLine().toString()+" - количество выходов",g.getIdProduct()));

        }




        String jsonOut = gson.toJson(gsonOut);



        return jsonOut;

    }



}
