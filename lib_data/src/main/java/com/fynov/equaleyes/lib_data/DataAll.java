package com.fynov.equaleyes.lib_data;

import java.util.ArrayList;

/**
 * Created by Bor on 05/03/2018.
 */

public class DataAll {
    ArrayList<Question> questions;
    String userMail;

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public DataAll(){
        questions = new ArrayList<>();
    }

    public void Scenario(){
        ArrayList<Answer> answers;
        questions = new ArrayList<>();

        answers = new ArrayList<Answer>();
        answers.add(new Answer(0, "iOS", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et nulla a nibh maximus volutpat sagittis eu lectus. Donec lobortis libero sed velit pretium ornare quis mollis quam. Aenean leo.", 10, 42, false, "x2"));
        answers.add(new Answer(1, "Android","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum porta erat, vitae volutpat sem tempor eget. Aliquam tincidunt scelerisque pretium. Nulla posuere tincidunt tellus, eu vehicula diam rhoncus ut.", 5, 50, false, "x1"));
        answers.add(new Answer(2, "Web","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse posuere a nisl id venenatis. Curabitur ac est urna. Sed et enim elementum, porta lacus non, bibendum felis. In enim sem.", 8, 4, false, "+"));
        questions.add(new Question(0, "Platform", answers));

        answers = new ArrayList<Answer>();
        answers.add(new Answer(0, "Small","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum porta erat, vitae volutpat sem tempor eget. Aliquam tincidunt scelerisque pretium. Nulla posuere tincidunt tellus, eu vehicula diam rhoncus ut.", 5, 50, false, "x1"));
        answers.add(new Answer(1, "Medium", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et nulla a nibh maximus volutpat sagittis eu lectus. Donec lobortis libero sed velit pretium ornare quis mollis quam. Aenean leo.", 10, 42, false, "x2"));
        answers.add(new Answer(2, "Large","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet sodales nunc, ornare tristique nisi commodo nec. Duis nec lacus id mauris suscipit semper. Nunc congue viverra sem, a pharetra.", 15, 22, false, "+"));
        answers.add(new Answer(3, "Huge","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse posuere a nisl id venenatis. Curabitur ac est urna. Sed et enim elementum, porta lacus non, bibendum felis. In enim sem.", 8, 4, false, "+"));
        questions.add(new Question(1, "How big is your app?", answers));

        answers = new ArrayList<Answer>();
        answers.add(new Answer(0, "Email", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et nulla a nibh maximus volutpat sagittis eu lectus. Donec lobortis libero sed velit pretium ornare quis mollis quam. Aenean leo.", 10, 42, false, "x2"));
        answers.add(new Answer(1, "Twitter","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum porta erat, vitae volutpat sem tempor eget. Aliquam tincidunt scelerisque pretium. Nulla posuere tincidunt tellus, eu vehicula diam rhoncus ut.", 5, 50, false, "x1"));
        answers.add(new Answer(2, "Google","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse posuere a nisl id venenatis. Curabitur ac est urna. Sed et enim elementum, porta lacus non, bibendum felis. In enim sem.", 8, 4, false, "+"));
        answers.add(new Answer(3, "Facebook","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet sodales nunc, ornare tristique nisi commodo nec. Duis nec lacus id mauris suscipit semper. Nunc congue viverra sem, a pharetra.", 15, 22, false, "+"));
        answers.add(new Answer(4, "LinkedIn","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum porta erat, vitae volutpat sem tempor eget. Aliquam tincidunt scelerisque pretium. Nulla posuere tincidunt tellus, eu vehicula diam rhoncus ut.", 5, 50, false, "x1"));
        answers.add(new Answer(5, "Github","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse posuere a nisl id venenatis. Curabitur ac est urna. Sed et enim elementum, porta lacus non, bibendum felis. In enim sem.", 8, 4, false, "+"));
        questions.add(new Question(2, "Users and accounts", answers));

        answers = new ArrayList<Answer>();
        answers.add(new Answer(0, "Messaging","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas fermentum porta erat, vitae volutpat sem tempor eget. Aliquam tincidunt scelerisque pretium. Nulla posuere tincidunt tellus, eu vehicula diam rhoncus ut.", 5, 50, false, "x1"));
        answers.add(new Answer(1, "Forums or commenting", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et nulla a nibh maximus volutpat sagittis eu lectus. Donec lobortis libero sed velit pretium ornare quis mollis quam. Aenean leo.", 10, 42, false, "x2"));
        answers.add(new Answer(2, "Social Sharing","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet sodales nunc, ornare tristique nisi commodo nec. Duis nec lacus id mauris suscipit semper. Nunc congue viverra sem, a pharetra.", 15, 22, false, "+"));
        answers.add(new Answer(3, "Push to Facebook Open Graph","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse posuere a nisl id venenatis. Curabitur ac est urna. Sed et enim elementum, porta lacus non, bibendum felis. In enim sem.", 8, 4, false, "+"));
        questions.add(new Question(3, "Socila and engagement", answers));
    }

    public void addQuestion(Question c){
        questions.add(c);
    }

    public void dumpQuestions(){
        questions.clear();
    }

    public Question getQuestion(int i){
        return  questions.get(i);
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
