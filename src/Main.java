import task1.number_game.GuessNumberGame;
import task2.student_grade_calculator.GradeCalculator;
import task3.atm_interface.BankATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {


            System.out.println("Enter your Choice..." +
                    "\n1. for Task 1 - Number Game" +
                    "\n2. for Task 2 - Student Grade Calculator" +
                    "\n3. for Task 3 - ATM Interface"+
                    "\n4. to Exit.....");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                GuessNumberGame gng = new GuessNumberGame();
                gng.startGame();
            } else if (choice == 2) {
                GradeCalculator gc = new GradeCalculator();
            } else if (choice == 3) {
                BankATM bkAtm = new BankATM();
            } else if(choice == 4) {
                flag = false;
            }
             else System.out.println("You Entered wrong Choice....");

            /*System.out.println("Press Y/y to do another Task : ");
            new Scanner(System.in).nextLine();
            String ch="";
            if (new Scanner(System.in).hasNextLine()) ch = new Scanner(System.in).next();
            else ch = new Scanner(System.in).next();
            if (!ch.toUpperCase().equals("Y")) flag = false;*/


        } while (flag);
    }
}