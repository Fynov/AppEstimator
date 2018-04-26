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

    public Answer(int id, String text, String details, int time, float value, boolean selected, String mod) {
        this.id = id;
        this.text = text;
        this.details = details;
        this.time = time;
        this.value = value;
        this.selected = selected;
        this.mod = mod;
    }
}
