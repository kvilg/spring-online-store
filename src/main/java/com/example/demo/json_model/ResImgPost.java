package com.example.demo.json_model;

import java.sql.Blob;
import java.util.LinkedList;
import java.util.List;

public class ResImgPost {
    public String statusReq;
    public String err;
    public List<DataImg> imgList = new LinkedList<>();

    public void setStatusReq(String statusReq) {
        this.statusReq = statusReq;
    }



}
