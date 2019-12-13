package com.sistemas51.horarioslavalle.models;

public class WeatherModel {

    String place;
    String description;
    String current;
    String minimum;
    String maximun;
    String image;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getMaximun() {
        return maximun;
    }

    public void setMaximun(String maximun) {
        this.maximun = maximun;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

