package task1.number_game;

import java.util.*;

public class RandomNumberGenerator {
    private int randomNumber;    

    //Setter
    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber; 
    } 

    //Getter
    public int getRandomNumber() {
        generateRandomNumber();
        return randomNumber;
    }    

    //Random Number Generator
    public void generateRandomNumber(){
        Random rand = new Random();
        setRandomNumber(rand.nextInt(100));
    }
}