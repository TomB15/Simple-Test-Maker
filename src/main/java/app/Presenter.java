package main.java.app;

public class Presenter {
    QuestionsList questionsList;

    public Presenter(QuestionsList questionsList){
        this.questionsList = questionsList;
    }

    public void startInTerminal(){
        TerminalPresenter terminal = new TerminalPresenter(questionsList);
        terminal.start();
    }
}
