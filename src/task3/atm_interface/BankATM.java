package task3.atm_interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BankATM{
    int currentBalance=0;
    static int initValue =0;

    ArrayList<BankUser> bankUsers;
    BankATM(int balance){
        this.currentBalance = balance;
    }
    public void depositAmount(int amount,String userid){
        currentBalance = bankUsers.get(indexOf(userid)).getBalance();
        currentBalance += amount;
        bankUsers.get(indexOf(userid)).setBalance(currentBalance);
    }
    public void withdrawAmount(int amount,String userid){
        if (currentBalance < amount)
            System.out.println("You do not have enough amount in your account.");
        else {
            currentBalance = bankUsers.get(indexOf(userid)).getBalance();
            currentBalance -= amount;
            bankUsers.get(indexOf(userid)).setBalance(currentBalance);
        }
    }
    public void createBankUsers(){
        bankUsers = new ArrayList<>();

        if (initValue==0){
            bankUsers.add(new BankUser("haritas",50000,"9876"));
            bankUsers.add(new BankUser("admin",50000,"1234"));
            bankUsers.add(new BankUser("shub123",50000,"7543"));
            initValue=1;
            return;
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n**********************************************************************");
        System.out.println("Please Enter UserID : ");
        String userid = sc.next();
        System.out.println("Please Enter Password : ");
        String pass = sc.next();
        System.out.println("Please Enter Current Deposit Amount : ");
        int bal = sc.nextInt();

        if(bankUsers.get(indexOf("admin")).getUser()!="admin") {
            System.out.println("This user is already Exist....\n Please try again...");
            return;
        }
        if(indexOf(userid)==-1) bankUsers.add(new BankUser(userid, bal, pass));

        sc.close();
    }

    public BankATM(){
        if(initValue==0) createBankUsers();
        init();
    }

    public void init(){
        System.out.println("\n\n\n**********************************************************************");
        System.out.println("###\tChoose Your Choice");
        System.out.println("\t->Create User \t\t Press 1");
        System.out.println("\t->Deposit \t\t Press 2");
        System.out.println("\t->Withdraw \t\t Press 3");
        int ch = new Scanner(System.in).nextInt();
        switch (ch){
            case 1 :
                createBankUsers();
                break;
            case 2, 3:
                banking(ch);
                break;
        }

    }
    public void banking(int ch) {
        System.out.println("\n\n\n**********************************************************************");
        System.out.println(">\tPlease Enter Your User ID  : ");
        String userid = new Scanner(System.in).nextLine();
        System.out.println(">\tPlease Enter Your Password : ");
        String password = new Scanner(System.in).nextLine();

        int counter = 0;
        while (userAuthenticity(userid, password)) {
            if (ch == 2) {
                System.out.println(">\tPlease Enter Amount to Deposit in the Account  : ");
                int amount = new Scanner(System.in).nextInt();
                depositAmount(amount,userid);
                System.out.println("**********************************************************************");
                System.out.println("Your Current Balance is : "+currentBalance);
                System.out.println("**********************************************************************");
            }

            if (ch == 3){
                System.out.println(">\tPlease Enter Amount to Deposit in the Account  : ");
                int amount = new Scanner(System.in).nextInt();
                withdrawAmount(amount,userid);
                System.out.println("**********************************************************************");
                System.out.println("Your Current Balance is : "+currentBalance);
                System.out.println("**********************************************************************");

            }
        }
        System.out.println("Entered UserId and Password is wrong...\nPlease try Again...");
    }
    public int indexOf(String userID) {
        int pointer = 0;
        for (BankUser i: bankUsers) {
            if (!userID.equals(i.getUser())){
                return pointer;
            }
            pointer++;
        }
        if (pointer == bankUsers.size()-1) {
            return -1;
        } else return 0;
    }
    boolean userAuthenticity(String userid, String password){
        for (BankUser i : bankUsers){
            if (userid.equals(i.getUser()) && password.equals(i.getPinCode())) return true;
        }
        return false;
    }
}
