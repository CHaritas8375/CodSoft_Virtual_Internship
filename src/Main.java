import task1.number_game.RandomNumberGenerator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        RandomNumberGenerator rand = new RandomNumberGenerator();
        int i=0;
        while (i<100) {
            int n =0;
            n=rand.getRandomNumber();

            if (n<1)   System.out.println(n);

            System.out.println(n);

            i++;

        }
    }
}