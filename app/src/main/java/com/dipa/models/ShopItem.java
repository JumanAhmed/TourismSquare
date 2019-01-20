package com.dipa.models;

/**
 * Created by Shuvo on 6/11/2017.
 */

public class ShopItem {

    private String title;
    private String type;
    private String address;
    private String contact;
    private String lat;
    private String lon;
    private int image;

    public String getLon() {
        return lon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLon(String lon) {
        this.lon = lon;

    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
