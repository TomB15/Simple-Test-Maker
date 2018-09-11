package main.java.app;

public class TerminalPresenter {
    private Questions questions;
    private int currentQuestionNo = 0;

    public TerminalPresenter(Questions questions){
        this.questions = questions;
    }

    public void start(){
        System.out.println("Welcome to simple testing software. \n" +
                "You can find some prepared question but note that they are not complete for preparing you for " +
                "OCA or OCP and neither are necessarily correct.\n\n" +
                "TEST INSTRUCTIONS \n" +
                "You will be ask 10 question and after each session you will be able to revise your answers.\n\n" +
                "----------------------------------- \n\n");

        startSession();
    }

    private void startSession(){
        currentQuestionNo = 1;
        Question question = questions.getRandomQuestion();

        System.out.println ("Question no. " + currentQuestionNo + ": " + question.getTitle());

        for(String choice : question.getChoices()){
            System.out.println(choice);
        }

    }
}
