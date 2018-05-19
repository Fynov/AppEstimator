package com.fynov.equaleyes.appestimator.data.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Template {
    private int ImageID;
    private String ImageUrl;
    private ArrayList<Template> templates;

    public Template(int ID) {ImageID = ID;}

    public Template(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public ArrayList<Template> getCahtegories() {
        return templates;
    }

    public void setCahtegories(ArrayList<Template> templates) {
        this.templates = templates;
    }
}
