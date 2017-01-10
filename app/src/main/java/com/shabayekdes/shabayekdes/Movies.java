package com.shabayekdes.shabayekdes;

/**
 * Created by SevenTG on 25/12/2016.
 */

public class Movies {
    public String name,year,type,rate;
    int img;
    String url;

    public Movies(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Movies(String name, String year, String type, String rate, int img) {
        this.name = name;
        this.year = year;
        this.type = type;
        this.rate = rate;
        this.img = img;
    }
}
