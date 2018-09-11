package main.java.app;

import java.util.LinkedList;
import java.util.Random;

public class Questions {
    private LinkedList<Question> questions = new LinkedList<>();

    public void add(Question question){
        questions.add(question);
    }

    public LinkedList<Question> getQuestions(){
        return questions;
    }

    public Question getRandomQuestion(){
        Random random = new Random();
        int i = random.nextInt(questions.size());

        return questions.get(i);
    }
}
