package main.java.app;

import java.util.LinkedList;
import java.util.Random;

public class Questions {
    private LinkedList<Question> questions = new LinkedList<>();
    private LinkedList<Question> randomQuestionsBuffer;

    public void add(Question question){
        questions.add(question);
        randomQuestionsBuffer = questions;
    }

    public LinkedList<Question> getQuestions(){
        return questions;
    }

    public Question getRandomQuestionFromBuffer(){
        Random random = new Random();
        int questionsSize = randomQuestionsBuffer.size();

        if(questionsSize == 0){
            return null;
        }

        int i = random.nextInt(questionsSize);

        Question q = randomQuestionsBuffer.get(i);
        randomQuestionsBuffer.remove(i);

        return q;
    }

    public void restartRandomQuestionsBuffer(){
        randomQuestionsBuffer = questions;
    }
}
