package com.fynov.equaleyes.appestimator.data.models;

import com.google.gson.annotations.SerializedName;


public class Template {
    @SerializedName("template_name")
    private String name;
    @SerializedName("url")
    private String ImageUrl;
    @SerializedName("check")
    private int check = 0;

    public Template(String name, String imageUrl) {
        this.name = name;
        ImageUrl = imageUrl;
    }

    public Template(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected(){
        if (this.check == 0) return false;
        return true;
    }
}
