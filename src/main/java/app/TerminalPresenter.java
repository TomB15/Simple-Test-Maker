package main.java.app;

import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TerminalPresenter {
    private Questions questions;
    private int currentQuestionNo = 0;
    private List<String[]> answersOfUser = new ArrayList<>();

    public TerminalPresenter(Questions questions){
        this.questions = questions;
    }

    public void start(){
        System.out.println("Welcome to simple testing software. \n" +
                "You can find some prepared question but note that they are not complete for preparing you for " +
                "OCA or OCP and neither are necessarily correct.\n\n" +
                "TEST INSTRUCTIONS \n" +
                "You will be asked 10 questions and after each session you will be able to revise your answers.\n");


        startSession();

        System.out.println("\n 1 - exclude past questions \n 2 - include past questions");
        //todo dokonči tuto funkcionalitu
    }

    private void startSession(){
        currentQuestionNo = 1;

        while(currentQuestionNo <= 10){
            Question question = questions.getRandomQuestionFromBuffer();
            String[] answersOfUser = new String[2];

            if(Objects.isNull(question)){
                break;
            }
            System.out.println("\n ----------------- Question no. " + currentQuestionNo + " -----------------");
            System.out.println (question.getTitle());

            for(String choice : question.getChoices()){
                System.out.println(choice);
            }

            Scanner sc = new Scanner(System.in);

            answersOfUser[1] = sc.nextLine();

            System.out.println("\n Correct answer is: ");
            for(String answer: question.getCorrectAnswers()){
                System.out.println("\t" + answer);
            }

            System.out.println("\n Were your answers right? (y or n)");

            sc = new Scanner(System.in);
            answersOfUser[0] = sc.nextLine();

            this.answersOfUser.add(answersOfUser);

            currentQuestionNo++;
        }

        //todo dokonči vypsání vyhodnocení
    }
}
