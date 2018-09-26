package main.java.app;

import java.util.ArrayList;
import java.util.List;

public class UserAnswer {

    private String questionTitle;
    private List<String> correctAnswers = new ArrayList<>();
    private List<String> answersOfUser = new ArrayList<>();
    private boolean answerIsCorrect;

    public UserAnswer(String questionTitle,
                      List<String> correctAnswers,
                      List<String> answersOfUser,
                      boolean answerIsCorrect){

        this.questionTitle = questionTitle;
        this.correctAnswers = correctAnswers;
        this.answersOfUser = answersOfUser;
        this.answerIsCorrect = answerIsCorrect;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public List<String> getAnswersOfUser() {
        return answersOfUser;
    }

    public boolean isAnswerIsCorrect() {
        return answerIsCorrect;
    }
}
