package main.java.app;

import java.util.List;
import java.util.ArrayList;

public class UserAnswersList {
    List<UserAnswer> userAnswersList = new ArrayList<>();
    private int numberOfCorrectAnswers = 0;

    public List<UserAnswer> getUserAnswersList() {
        return userAnswersList;
    }

    public void add(UserAnswer userAnswer){
        if(userAnswer.isAnswerIsCorrect()){
            numberOfCorrectAnswers++;
        }

        userAnswersList.add(userAnswer);
    }

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }
}
