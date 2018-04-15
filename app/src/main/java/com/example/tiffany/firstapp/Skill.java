package com.example.tiffany.firstapp;

/**
 * Created by Tiffany on 23/03/2018.
 */

public class Skill {
    private String name;
    private String percentage;

    public Skill(){

    }

    public Skill(String name, String percentage){
        this.name = name;
        this.percentage = percentage;
    }

    public String getName(){
        return name;
    }


    public String getPercentage(){
        return percentage;
    }

}
