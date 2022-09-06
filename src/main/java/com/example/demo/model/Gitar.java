package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gitar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer price;

    private String name, type, sensors;

    private Long idProduct;


    public Gitar() {

    }

    public Gitar(String name, Integer price, String type, String sensors, Long idProduct) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.sensors = sensors;
        this.idProduct = idProduct;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSensors() {
        return sensors;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }
}


