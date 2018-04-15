package com.example.tiffany.firstapp;

import com.google.firebase.database.PropertyName;

/**
 * Created by tiffany on 13/03/2018.
 */

public class Project {

    @PropertyName("Name")
    private  String name;
    @PropertyName("Description")
    private  String description;
    @PropertyName("CategoryName")
    private  String categoryName;
    private  String categorycolor;
    private  String sitelink;
    @PropertyName("Img")
    private  String img;

    public Project() {
    }

    public Project(String name, String description, String categoryName, String categorycolor, String sitelink, String img) {
        this.name = name;
        this.description = description;
        this.categoryName = categoryName;
        this.categorycolor = categorycolor;
        this.sitelink = sitelink;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategorycolor() {
        return categorycolor;
    }

    public String getSitelink() {
        return sitelink;
    }

    public String getImg() {
        return img;
    }



}
