package com.fynov.equaleyes.appestimator.data.models;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Category {
    private String categoryId;
    @SerializedName("feature_name")
    private String name;
    private Double time;
    @SerializedName("feature")
    private ArrayList<Feature> features;

    public Category(String categoryId, String name, Double time, ArrayList<Feature> features) {
        this.categoryId = categoryId;
        this.name = name;
        this.time = time;
        this.features = features;
    }

    public Category(String name, ArrayList<Feature> features) {
        this.name = name;
        this.features = features;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String id) {
        this.categoryId = id;
    }

    public String timeToString() {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        return format.format(time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Feature> features) {
        this.features = features;
    }
}
