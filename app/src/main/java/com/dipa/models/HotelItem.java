package com.dipa.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuvo on 6/9/2017.
 */

public class HotelItem implements  Serializable{

    private String name;
    private String location;
    private String address;
    private String contact;
    private int imageLogo;
    private ArrayList<Slider> imageSlider;
    private String email;
    private String fb;
    private String wifi;
    private String lat;
    private String lon;

    public HotelItem(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getImageLogo() {
        return imageLogo;
    }

    public void setImageLogo(int imageLogo) {
        this.imageLogo = imageLogo;
    }

    public ArrayList<Slider> getImageSlider() {
        return imageSlider;
    }

    public void setImageSlider(ArrayList<Slider> imageSlider) {
        this.imageSlider = imageSlider;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }


    public static class Slider{
        private int image;

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }


}
