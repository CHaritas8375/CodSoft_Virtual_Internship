package task1.number_game;

import java.util.Scanner;

public class GuessNumberGame {
    int score=0;
    public String scoreCounter(String result){
        if (result.equals("Correct")) score++;
        return result;
    }

    public String fetchData(){
       GuessEvaluator ge = new GuessEvaluator();
       ge.userInput();
       return scoreCounter(ge.evaluateGuess(new RandomNumberGenerator().getRandomNumber()));
    }

    public void startGame(){
        int lives = 0;
        do{
            String r = fetchData();

            if (r.equals("Correct")){
                System.out.println("You have Guessed it Correctly. your Score..."+score);
                System.out.println("\n\nDo you want to play more or Leave this game With Score : "+score+"\nPress 1. To play\nPress Any Number To Quit");
                int choice = 0;
                choice = new Scanner(System.in).nextInt();
                    if (choice==1){
                        lives=0;
                    }
                    else lives = 4;
            }
            if (lives<3 && !r.equals("Correct") && lives<3){
                System.out.println(r);
                lives++;
            }
            if (lives==3){
                System.out.println("\n\nDo you want to play more or Leave this game With Score : "+score+"\nPress 1. To play\nPress Any Number To Quit");
                int choice = 0;
                choice = new Scanner(System.in).nextInt();
                if (choice==1){
                    lives=0;
                }
                else lives = 3;
            }
        }while(lives<3);
        System.out.println("\n\n\nThank For Playing \"GUESS THE NUMBER GAME\"");
        System.out.println("Your Total Score : "+score);
    }
}