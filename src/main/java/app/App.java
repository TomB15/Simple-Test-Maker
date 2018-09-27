package main.java.app;

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
}
