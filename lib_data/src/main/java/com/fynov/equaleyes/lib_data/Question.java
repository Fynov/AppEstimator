package com.fynov.equaleyes.lib_data;

import java.util.ArrayList;

public class Question {
    int id;
    String text;
    ArrayList<Answer> answers;

    public Question(int id, String text, ArrayList<Answer> answers) {
        this.id = id;
        this.text = text;
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
