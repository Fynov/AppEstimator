package com.fynov.equaleyes.lib_data;

/**
 * Created by Bor on 04/04/2018.
 */

public class Answer {
    int id;
    public String text;
    public String details;
    int time;
    float value;
    public boolean selected;
    String mod;

    public Answer(){}

    public Answer(int id, String text, String details, int time, float value, boolean selected, String mod) {
        this.id = id;
        this.text = text;
        this.details = details;
        this.time = time;
        this.value = value;
        this.selected = selected;
        this.mod = mod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
