package main.java.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class QuestionsLoader {
    private QuestionsList questionsList;

    public QuestionsLoader(QuestionsList questionsList){
        this.questionsList = questionsList;
    }

    public void loadQuestions(){
        URL url = getClass().getResource("../questions/OCA.md");
        File file = new File(url.getPath());
        Scanner sc = new Scanner("");

        try{
            sc = new Scanner(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        String fileTitle = "";
        String questionTitle = "";
        List<String> questionChoices = new ArrayList<>();
        List<String> questionCorrectAnswers = new ArrayList<>();
        String ln;

        READ_FILE_LOOP: while(sc.hasNextLine()){
            ln = sc.hasNext() ? sc.next() : "";

            switch(ln){
                case ("#"): //file title
                    fileTitle = sc.nextLine();
                    break;
                case("##"): //question title
                    questionTitle = sc.nextLine();
                    break;
                case("*"): //question choices
                    questionChoices.add(sc.nextLine());
                    break;
                case("--"): //correct answers
                    questionCorrectAnswers.add(sc.nextLine());
                    break;
                case("-----"): //end of question
                    questionsList.add(
                            new Question(
                                    questionTitle,
                                    questionChoices,
                                    questionCorrectAnswers
                            ));
                    questionTitle = "";
                    questionChoices.clear();
                    questionCorrectAnswers.clear();
                    break;
                case("----END-OF-FILE----"):
                    break READ_FILE_LOOP;
            }
        }

        sc.close();
    }
}
