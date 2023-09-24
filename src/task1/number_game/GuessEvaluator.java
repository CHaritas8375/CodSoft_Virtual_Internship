package task1.number_game;

import java.util.Scanner;

public class GuessEvaluator {
	private int userNumber;

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public void userInput(){
		System.out.print("Enter upcoming Number : ");
        this.userNumber = new Scanner(System.in).nextInt();

	}

	public String evaluateGuess(int generatedNumber){
		int num = new RandomNumberGenerator().getRandomNumber();
		int difference = num - getUserNumber();

		if (difference==0)							return "Correct";
		else if (difference>0 && difference<=50)	return "Low";
		else if (difference>50 && difference<=100)	return "Too Low";
		else if (difference<0 && difference>=-50) 	return "High";
		else if (difference<-50 && difference>=-100)return "Too High";
		else return "Invalid"+num+" "+ getUserNumber();
	}
}
