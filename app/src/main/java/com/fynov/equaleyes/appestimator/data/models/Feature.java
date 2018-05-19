package com.fynov.equaleyes.appestimator.data.models;

import com.google.gson.annotations.SerializedName;

public class Feature {
    private String id;
    @SerializedName("name")
    private String name;
    private String description;
    private Integer price;
    @SerializedName("time")
    private Integer time;
    private Boolean selected = false;

    public Feature(String id, String name, String description, Integer price, Integer time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.time = time;
    }

    public Feature(String id, String name, String description, Integer price, Integer time, Boolean selected) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.time = time;
        this.selected = selected;
    }

    public Boolean isSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
