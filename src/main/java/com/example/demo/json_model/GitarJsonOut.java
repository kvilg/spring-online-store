package com.example.demo.json_model;

import java.util.LinkedList;
import java.util.List;

public class GitarJsonOut {

    public List<GitarS> git;


    public GitarJsonOut(){
        this.git = new LinkedList<>();
    }

    public static class GitarS {

        public GitarS(String nameGit,Integer priceGit,String typeGit,String sensorsGit,Long idProd){
            this.nameGit = nameGit;
            this.priceGit = priceGit;
            this.typeGit = typeGit;
            this.sensorsGit = sensorsGit;
            this.idProd = idProd;
        }
        public String nameGit;
        public Integer priceGit;
        public String typeGit;
        public String sensorsGit;
        public Long idProd;
    }
}

