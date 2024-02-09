package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String number = NumberCreator.create();
        System.out.println("The number is hidden. You can start guessing! Enter your guess!");
        String guess;
        Scanner in = new Scanner(System.in);

        while(!AnswerProcessor.isGuessed()) {
            guess = in.next();
            if (!AnswerProcessor.isGuessValid(guess)) {
                System.out.println("it seems that you entered an incorrect answer. It should consist of 4 digits without divisions. Try again...");
            }
            else {
                AnswerProcessor.check(guess, number);
                int cowsNumb = AnswerProcessor.getMismatchingPos();
                int bullsNumb = AnswerProcessor.getMatchingPos();
                if (!AnswerProcessor.isGuessed()) {
                    System.out.println("Your answer contains:\nCows: " + cowsNumb + "\nBulls: " + bullsNumb);
                    System.out.println("Go on! You're getting close!");
                }
            }
        }
        System.out.println("Congratulations! That's right! Right answer: " + number);
    }
}