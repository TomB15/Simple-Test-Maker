package main.java.app;

import java.util.List;
import java.util.ArrayList;

public class Question {

    private String title;
    private List<String> choices;
    private List<String> correctAnswers;

    public Question(String title,
                    List<String> choices,
                    List<String> correctAnswers){
        this.title = title;
        this.choices = new ArrayList<>(choices);
        this.correctAnswers = new ArrayList<>(correctAnswers);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getChoices() {
        return choices;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }
}
