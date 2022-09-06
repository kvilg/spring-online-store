package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {



    @GetMapping("/")
    public String index(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            System.out.printf("Header '%s' = %s%n", key, value);
        });
        System.out.println("\n\n\n\n\n\n\n\n\n\n");


        return "index";
    }

    @GetMapping("/catalog")
    public String catalog(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            System.out.printf("Header '%s' = %s%n", key, value);
        });
        System.out.println("\n\n\n\n\n\n\n\n\n\n");

        return "catalog";
    }

    /**
     * Тут нуно указать какой HTML вернуть
     *
     * ps.
     * да я знаю что это кастылm
     * правильно делать генерацию основных элементов через js
     *
     * PS,PS.
     * ЖДИТЕ ИСПРАВЛЕНИЕ Я ВЕРНУСЬ С ПЕРВЫМ ЛУЧОМ СОЛНЦА, НА 5 ДЕНЬ, С ВОСТОКА
     *
     *
     * PS.PS.PS
     *
     * ПОСЛЕ ИСРАВЛЕНИЯ ТУТ ПРОИСХОДИТ КАКОЙ-ТО ПИ*#@Ц ДАЖЕ НЕ ПРОБУЙ ТУТ
     * В ЧЕМ ТО РАЗОБРАТЬСЯ
     * */

    @GetMapping("/product/{type}")
    public String product(@PathVariable(value = "type") String type, Model model) {
        model.addAttribute("productNow",type);

        return "gitar";
    }

    @GetMapping("/getProduct/{id}/{type}")
    public String getProduct(@PathVariable(value = "id") String id,@PathVariable(value = "type") String type, Model model) {
        model.addAttribute("id",id);
        model.addAttribute("type",type);
        System.out.println();

        return "product";
    }

    @GetMapping("/admin")
    public String getAdmin() {


        return "admin";
    }

    @GetMapping("/login")
    String login(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            System.out.printf("Header '%s' = %s%n", key, value);
        });
        System.out.println("\n\n\n\n\n\n\n\n\n\n");


        return "login";
    }

}