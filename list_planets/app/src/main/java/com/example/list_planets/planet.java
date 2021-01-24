package com.example.list_planets;

import android.media.Image;

public class planet {

    private int icon = R.drawable.planet;
    private String name = "";
    private String weight = "";
    private String desc = "";
    private String radius = "";
    private String age = "";
    private String speed = "";

    public String getName(){
        return this.name;
    }
    public String getWeight(){
        return this.weight;
    }
    public int getIcon(){
        return this.icon;
    }
    public String getDesc(){
        return this.desc;
    }
    public String getRadius(){
        return this.radius;
    }
    public String getAge(){
        return this.age;
    }
    public String getSpeed(){
        return this.speed;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setRadius(String radius){
        this.radius = radius;
    }
    public void setAge(String age){
        this.age = age;
    }
    public void setSpeed(String speed){
        this.speed = speed;
    }
}
