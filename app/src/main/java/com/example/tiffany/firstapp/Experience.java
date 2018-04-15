package com.example.tiffany.firstapp;

/**
 * Created by Tiffany on 23/03/2018.
 */

public class Experience {
    private String establishment;
    private String place;
    private String period;

    public Experience(){

    }

    public Experience(String establishment, String place, String period){
        this.establishment = establishment;
        this.place = place;
        this.period = period;
    }

    public String getEstablishment(){
        return establishment;
    }

    public String getPlace(){
        return  place;
    }

    public String getPeriod(){
        return period;
    }

}
