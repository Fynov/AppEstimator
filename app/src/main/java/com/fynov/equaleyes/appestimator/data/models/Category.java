package com.fynov.equaleyes.appestimator.data.models;

import java.util.ArrayList;

public class Category {
    private String id;
    private String name;
    private Integer time;
    private ArrayList<Feature> features;

    public Category(String id, String name, Integer time, ArrayList<Feature> features) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.features = features;
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
