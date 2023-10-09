package task3.atm_interface;

import java.util.ArrayList;

public class BankUser {
    String mUser;
    int mBalance;
    String mPinCode;

    BankUser(String name,int balance,String accountNumber){
        this.mUser = name;
        this.mBalance = balance;
        this.mPinCode = accountNumber;
    }
    public String getUser() {
        return mUser;
    }
    public void setUser(String mUser) {
        this.mUser = mUser;
    }
    public int getBalance() {
        return mBalance;
    }
    public void setBalance(int mBalance) {
        this.mBalance = mBalance;
    }
    public String getPinCode() {
        return mPinCode;
    }
    public void setPinCode(String mPinCode) {
        this.mPinCode = mPinCode;
    }
    //create
    public BankUser createUser(String userId,int balance,String password){
        return new BankUser(userId,balance,password);
    }
}
