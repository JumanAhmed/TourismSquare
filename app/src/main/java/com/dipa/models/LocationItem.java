package com.dipa.models;

import android.location.Location;

/**
 * Created by Shuvo on 3/27/2017.
 */

public class LocationItem {

    private int id;
    private String placeName;
    private int distance;
    private int image;
    private String descriptionBengali;
    private String descriptionEnglish;
    private String lat;
    private String lon;
    ;

    private LocationItem(Builder builder) {
        this.id = builder.id;
        this.placeName = builder.placeName;
        this.distance = builder.distance;
        this.image = builder.image;
        this.descriptionBengali = builder.descriptionBengali;
        this.descriptionEnglish = builder.descriptionEnglish;
        this.lat = builder.lat;
        this.lon = builder.lon;

    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int id;
        private String placeName;
        private int distance;
        private int image;
        private String descriptionBengali;
        private String descriptionEnglish;
        private String lat;
        private String lon;

        public Builder withId(int id){
            this.id = id;
            return this;
        }

        public Builder withPlaceName(String placeName){
            this.placeName = placeName;
            return this;
        }

        public Builder withDistance(int distance){
            this.distance = distance;
            return this;
        }

        public Builder withDescriptionBengali(String descriptionBengali){
            this.descriptionBengali = descriptionBengali;
            return this;
        }

        public Builder withDescriptionEnglish(String descriptionEnglish){
            this.descriptionEnglish = descriptionEnglish;
            return this;
        }

        public Builder withLatitude(String latitude){
            this.lat = latitude;
            return this;
        }

        public Builder withLongitude(String longitude){
            this.lon = longitude;
            return this;
        }

        public Builder withDrawableImage(int drawableImage){
            this.image = drawableImage;
            return this;
        }

        public LocationItem build(){
            return new LocationItem(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getDistance() {
        return distance;
    }

    public String getDescriptionBengali() {
        return descriptionBengali;
    }

    public String getDescriptionEnglish() {
        return descriptionEnglish;
    }

    public String getLat() {
        return lat;
    }

    public int getDrawableImage() {
        return image;
    }

    public String getLon() {
        return lon;
    }
}
