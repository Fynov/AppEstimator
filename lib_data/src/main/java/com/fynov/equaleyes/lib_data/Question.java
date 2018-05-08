package com.fynov.equaleyes.lib_data;

import java.util.ArrayList;

public class Question {
    int id;
    String text;
    ArrayList<Answer> answers;

    public Question(){}

    public Question(int id, String text, ArrayList<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
