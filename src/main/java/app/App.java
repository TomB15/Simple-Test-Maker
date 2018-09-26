package main.java.app;

import java.util.LinkedList;

public class App {
    QuestionsList questionsList = new QuestionsList();
    QuestionsLoader questionsLoader;
    Presenter presenter;

    public static void main(String args[]){
        App app = new App();

        app.questionsLoader = new QuestionsLoader(app.questionsList);
        app.questionsLoader.loadQuestions();

        app.presenter = new Presenter(app.questionsList);

        app.start();
    }

    private void start(){
        presenter.startInTerminal();
    }

    private void test(){
        LinkedList<Question> qs = questionsList.getQuestions();

        for(Question q : qs){
            System.out.println(q.getTitle());
        }
    }
}
