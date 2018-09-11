package main.java.app;

import java.util.List;

public class Question {

    private String title;
    private List<String> choices;
    private List<String> correctAnswer;
    private int result;

    public Question(String title, List<String> choices, List<String> correctAnswer){
        this.title = title;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getChoices() {
        return choices;
    }

    public List<String> getCorrectAnswer() {
        return correctAnswer;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
