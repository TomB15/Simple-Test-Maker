package main.java.app;

public class Presenter {
    Questions questions;

    public Presenter(Questions questions){
        this.questions = questions;
    }

    public void startInTerminal(){
        TerminalPresenter terminal = new TerminalPresenter(questions);
        terminal.start();
    }
}
