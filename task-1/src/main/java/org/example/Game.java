package org.example;

import java.util.Scanner;

public class Game {
    public void start() {
        String number = NumberCreator.create();
        System.out.println("The number is hidden. You can start guessing! Enter your guess!");
        String guess;
        Scanner in = new Scanner(System.in);

        AnswerProcessor answerProc = new AnswerProcessor();
        while(!answerProc.isGuessed()) {
            guess = in.next();
            if (!DigitValidator.isNumberValid(guess, 4)) {
                System.out.println("it seems that you entered an incorrect answer. It should consist of 4 digits without divisions. Try again...");
            }
            else {
                answerProc.check(guess, number);
                int cowsNumb = answerProc.getMisMatchingPos();
                int bullsNumb = answerProc.getMatchingPos();
                if (!answerProc.isGuessed()) {
                    System.out.println("Your answer contains:\nCows: " + cowsNumb + "\nBulls: " + bullsNumb);
                    System.out.println("Go on! You're getting close!");
                }
            }
        }
        System.out.println("Congratulations! That's right! Right answer: " + number);
    }
}
