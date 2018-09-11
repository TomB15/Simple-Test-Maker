package main.java.app;

import java.util.LinkedList;

public class App {
    Questions questions = new Questions();
    QuestionsLoader questionsLoader;
    Presenter presenter;

    public static void main(String args[]){
        App app = new App();

        app.questionsLoader = new QuestionsLoader(app.questions);
        app.questionsLoader.loadQuestions();

        app.presenter = new Presenter(app.questions);

        app.start();
    }

    private void start(){
        presenter.startInTerminal();
    }

    private void test(){
        LinkedList<Question> qs = questions.getQuestions();

        for(Question q : qs){
            System.out.println(q.getTitle());
        }
    }
}
