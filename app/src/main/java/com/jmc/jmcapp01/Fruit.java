package com.jmc.jmcapp01;

/**
 * Created by User on 2016/5/31.
 */
public class Fruit {
    private String name;
    private  int imageId;

    public Fruit(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }

}
