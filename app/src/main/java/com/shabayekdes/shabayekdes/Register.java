package com.shabayekdes.shabayekdes;

import java.io.Serializable;

/**
 * Created by SevenTG on 24/12/2016.
 */

public class Register implements Serializable {
    String fname,lname,country;
    int ddate,mdate,ydate;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDdate() {
        return ddate;
    }

    public void setDdate(int ddate) {
        this.ddate = ddate;
    }

    public int getMdate() {
        return mdate;
    }

    public void setMdate(int mdate) {
        this.mdate = mdate;
    }

    public int getYdate() {
        return ydate;
    }

    public void setYdate(int ydate) {
        this.ydate = ydate;
    }
}
