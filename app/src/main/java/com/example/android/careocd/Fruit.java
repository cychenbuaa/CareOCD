package com.example.android.careocd;

/**
 * Created by chunyu on 2017/5/8.
 */

//定义一个实体类
public class Fruit{
    private String name;
    private int imageId;
    public Fruit(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public  String getName(){

        return name;
    }
    public int getImageId(){

        return  imageId;
    }
}
