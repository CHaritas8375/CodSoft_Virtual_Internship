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
        currentBalance = bankUsers.get(indexOf(userid)).getBalance();
        if (currentBalance < amount)
            System.out.println("You do not have enough amount in your account.");
        else {
            currentBalance = currentBalance - amount;
            bankUsers.get(indexOf(userid)).setBalance(currentBalance);
        }
    }
    public void createBankUsers(){
        bankUsers = new ArrayList<>();

        if (initValue==0){
            bankUsers.add(new BankUser("haritas",1000,"9876"));
            bankUsers.add(new BankUser("admin",50000,"1234"));
            bankUsers.add(new BankUser("shub123",3000,"7543"));
            initValue=1;
            return;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n**********************************************************************");
        System.out.println("Please Enter UserID : ");
        String userid = scan.next();
        System.out.println("Please Enter Current Deposit Amount : ");
        int bal = Integer.parseInt(scan.next().toString());
        System.out.println("Please Enter Password : ");
        String pass = scan.next();

        if(indexOf(userid)>0) {
            System.out.println("This user is already Exist....\n Please try again...");
            return;
        }
        if(indexOf(userid)==-1) bankUsers.add(new BankUser(userid, bal, pass));
        scan.close();
    }

    public BankATM(){
        if(initValue==0) createBankUsers();
        init();
    }

    public void init(){
        boolean flag = true;
        do {
            System.out.println("\n\n\n**********************************************************************");
            System.out.println("\t\tWELCOME TO ABC BANK ATM SERVICES");
            System.out.println("**********************************************************************");
            System.out.println("###\tChoose Your Option");
            System.out.println("\t->Create User \t\t Press 1");
            System.out.println("\t->Deposit \t\t\t Press 2");
            System.out.println("\t->Withdraw \t\t\t Press 3");
            System.out.println("\t->User Details \t\t Press 4");
            System.out.println("\t->Exit..... \t\t Press any other Key..,");
            int ch = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (ch) {
                case 1:
                    createBankUsers();
                    break;
                case 2, 3:
                    banking(ch);
                    break;
                case 4:
                    showUserData();
                    break;
                default:
                    System.out.println("\n\n\n**********************************************************************");
                    System.out.println("\t\tThanks for Using Our Banking Service...");
                    System.out.println("**********************************************************************");
                    flag=false;
            }

        }while (flag);
    }
    public void banking(int ch) {
        System.out.println("\n\n\n**********************************************************************");
        System.out.println(">\tPlease Enter Your User ID  : ");
        String userid = new Scanner(System.in).next();
        System.out.println(">\tPlease Enter Your Password : ");
        String password = new Scanner(System.in).next();

        if (userAuthenticity(userid, password)) {
            if (ch == 2) {
                System.out.println(">\tPlease Enter Amount to Deposit in the Account  : ");
                int amount = new Scanner(System.in).nextInt();
                depositAmount(amount,userid);
                System.out.println("**********************************************************************");
                System.out.println("\tYour("+bankUsers.get(indexOf(userid)).getUser()+"'s) Current Balance is : "+currentBalance);
                System.out.println("**********************************************************************");
            }

            if (ch == 3){
                System.out.println(">\tPlease Enter Amount to Withdraw from the Account  : ");
                int amount = new Scanner(System.in).nextInt();
                withdrawAmount(amount,userid);
                System.out.println("**********************************************************************");
                System.out.println("\tYour ("+bankUsers.get(indexOf(userid)).getUser()+"'s)Current Balance is : "+currentBalance);
                System.out.println("**********************************************************************");
            }
        }else   System.out.println("Entered UserId and Password is wrong...\nPlease try Again...");

    }
    public int indexOf(String userID) {
        int pointer = 0;
        for (BankUser i: bankUsers) {
            if (!userID.equals(i.getUser())){
                return pointer+1;
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

    void showUserData(){
        System.out.println("\n\n\n**********************************************************************");
        for (BankUser i: bankUsers){
            System.out.println("\t "+i.getUser()+"\t : \t"+i.getBalance());
        }
    }

}
