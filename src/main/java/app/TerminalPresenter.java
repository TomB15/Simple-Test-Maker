package main.java.app;

import java.util.*;

public class TerminalPresenter {
    private QuestionsList questionsList;
    private int currentQuestionNo = 0;
    private List<String[]> answersOfUser = new ArrayList<>();
    UserAnswersList userAnswersList = new UserAnswersList();

    public TerminalPresenter(QuestionsList questionsList){
        this.questionsList = questionsList;
    }

    public void start(){
        System.out.println("Welcome to simple testing software. \n" +
                "You can find some prepared question but note that they are not complete for preparing you for " +
                "OCA or OCP and neither are necessarily correct.\n\n" +
                "TEST INSTRUCTIONS \n" +
                "You will be asked 10 questions and after each session you will be able to revise your answers.\n" +
                "To finish entering your answers press ENTER twice.");


        startSession();

        System.out.println("\n 1 - exclude past questions \n 2 - include past questions");
        //todo dokonči tuto funkcionalitu
    }

    private void startSession(){
        currentQuestionNo = 1;

        while(currentQuestionNo <= 3){
            Question question = questionsList.getRandomQuestionFromBuffer();

            if(Objects.isNull(question)){
                break;
            }

            printQuestion(question);

            List<String> answers = new ArrayList<>(loadUserAnswers());
            Scanner sc = new Scanner(System.in);

            printCorrectAnswers(question);

            boolean answerIsCorrect = wasTheAnswerCorrect();

            //todo přidej všechno do useranswer a useranserslist
            currentQuestionNo++;
        }

        printResultsReview();

        //todo dokonči vypsání vyhodnocení
    }

    private void printQuestion(Question question) {
        System.out.println("\n ----------------- Question no. " + currentQuestionNo + " -----------------");
            System.out.println (question.getTitle());

            for(String choice : question.getChoices()){
                System.out.println(choice);
            }

    }

    private void printCorrectAnswers(Question question) {
        System.out.println("\n Correct answer is: ");
            for(String answer: question.getCorrectAnswers()){
                System.out.println("\t" + answer);
            }
    }


    private List<String> loadUserAnswers(){
       List<String> answers = new ArrayList<>();
       Scanner sc;
       int enterCounter = 0;

       LOADING: for(;;){
          sc =  new Scanner(System.in);
          String line = sc.nextLine();
          TerminalPresenter.checkIfTimeToExit(line);

          if(line.isEmpty()){
              enterCounter++;
          } else {
              enterCounter = 0;
          }

          if(enterCounter == 2){
              break LOADING;
          }


          answers.add(line);
       }

      return answers;
    }

    private boolean wasTheAnswerCorrect() {
        Scanner sc;
        boolean answerIsCorrect = false;
        boolean hasMarkedAnswer = false;

        System.out.println("\n Were your answers right? (y or n)");

        do {
            sc = new Scanner(System.in);
            String line = sc.nextLine();
            TerminalPresenter.checkIfTimeToExit(line);

            if(! line.equals("y") & ! line.equals("n")) {
                System.out.println("Please, answer only \"y\" or \"n\".");

            } else if(line.equals("y")) {
                answerIsCorrect = true;
                hasMarkedAnswer = true;
            } else {
                answerIsCorrect = false;
                hasMarkedAnswer = true;
            }

        }while(! hasMarkedAnswer);

        return answerIsCorrect;
    }


    private void printResultsReview(){
        System.out.println("\n  ***********Answers review ***********");


        for(String[] userAnswer : answersOfUser){
            System.out.println("\n Question: " + userAnswer[0]);
            System.out.println("Marked as " + ( userAnswer[1].equals("y") ? "CORRECT" : "INCORRECT" ));
            System.out.println("Your answers: " ); //todo display user's answers

            for(String answer : userAnswer){
                System.out.println(answer);
            }
        }
    }

    public static void checkIfTimeToExit(String str){
        if(str.equals("exit")){
            System.out.println("-------------------- EXIT -------------------- ");
            System.exit(1);
        }
    }
}
