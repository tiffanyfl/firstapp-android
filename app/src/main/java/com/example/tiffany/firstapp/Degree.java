package com.example.tiffany.firstapp;

/**
 * Created by Tiffany on 23/03/2018.
 */

public class Degree {
    private String name;
    private String establishment;
    private String place;
    private String graduation;

    public Degree(){

    }

    public Degree(String name, String establishment, String place, String graduation){
        this.name = name;
        this.establishment = establishment;
        this.place = place;
        this.graduation = graduation;
    }

    public String getName(){
        return name;
    }

    public String getEstablishment() {
        return establishment;
    }

    public String getPlace() {
        return place;
    }

    public String getGraduation(){
        return graduation;
    }
}
