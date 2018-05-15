package com.fynov.equaleyes.appestimator.data.models;

import java.util.ArrayList;

public class Category {
    private String categoryId;
    private String name;
    private Integer time;
    private ArrayList<Feature> features;

    public Category(String categoryId, String name, Integer time, ArrayList<Feature> features) {
        this.categoryId = categoryId;
        this.name = name;
        this.time = time;
        this.features = features;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String id) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Feature> features) {
        this.features = features;
    }
}
