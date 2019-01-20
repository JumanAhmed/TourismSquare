package com.dipa.models;

/**
 * Created by Shuvo on 6/9/2017.
 */

public class RestaurantItem {

    private int id;
    private String title;
    private int imageSmall;
    private int imageBig;
    private String cuisine;
    private String contact;
    private String address;
    private String location;
    private String openCloseTime;
    private String parking;
    private String email;
    private String fb;
    private String lat;
    private String lon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(int imageSmall) {
        this.imageSmall = imageSmall;
    }

    public int getImageBig() {
        return imageBig;
    }

    public void setImageBig(int imageBig) {
        this.imageBig = imageBig;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpenCloseTime() {
        return openCloseTime;
    }

    public void setOpenCloseTime(String openCloseTime) {
        this.openCloseTime = openCloseTime;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
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
}
