import task1.number_game.GuessNumberGame;
import task2.student_grade_calculator.GradeCalculator;
import task3.atm_interface.BankATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        do{


           System.out.println("Enter your Choice..." +
                   "\n1. for Task 1 - Number Game"+
                   "\n2. for Task 2 - Student Grade Calculator"+
                   "\n3. for Task 3 - ATM Interface");

           int choice = new Scanner(System.in).nextInt();

           switch (choice){
                case 1:
                    GuessNumberGame gng = new GuessNumberGame();
                    gng.startGame();
                    break;
                case 2:
                    GradeCalculator gc = new GradeCalculator();
                    break;
                case 3:
                    BankATM bkAtm = new BankATM();
                    break;
                default:
                    System.out.println("You Entered wrong Choice....");
           }

           System.out.println("Press Y/y to do another Task : ");
           String ch = new Scanner(System.in).nextLine();
           if (!ch.toUpperCase().equals("Y")) flag = false;


        }while(flag);
    }
}