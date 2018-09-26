package main.java.app;

import java.util.List;
import java.util.ArrayList;

public class UserAnswersList {
    List<UserAnswer> userAnswersList = new ArrayList<>();

    public List<UserAnswer> getUserAnswersList() {
        return userAnswersList;
    }

    public void add(UserAnswer userAnswer){
        userAnswersList.add(userAnswer);
    }
}
