import task1.number_game.GuessNumberGame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       System.out.println("Enter your Choice..." +
               "\n1. for Task 1 - Number Game"+
               "\n2. for Task 2 - Student Grade Calculator");
       
        int choice = new Scanner(System.in).nextInt();

        switch (choice){
            case 1:
                GuessNumberGame gng = new GuessNumberGame();
                gng.startGame();
                break;
            case 2:

                break;
            default:
                System.out.println("You Entered wrong Choice....");
        }
    }
}