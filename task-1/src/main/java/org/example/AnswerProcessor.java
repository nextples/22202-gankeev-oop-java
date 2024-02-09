package org.example;

import java.util.Objects;
import java.util.regex.*;

public class AnswerProcessor {
    private static int matchingPos = 0;
    private static int mismatchingPos = 0;
    private static boolean isAnswered = false;

    public static int getMatchingPos() {
        return matchingPos;
    }

    public static int getMismatchingPos() {
        return mismatchingPos;
    }

    public static boolean isGuessed() {
        return isAnswered;
    }

    public static boolean isGuessValid(String guess) {
        Pattern validRegex = Pattern.compile("^[0-9]{4}$");
        Matcher matcher = validRegex.matcher(guess);
        return matcher.find();
    }

    public static void check(String guess, String answer) {
        matchingPos = 0;
        mismatchingPos = 0;
        if (Objects.equals(guess, answer)) {
            isAnswered = true;
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == answer.charAt(i)) {
                    matchingPos++;
                }
                else {
                    if (answer.indexOf(guess.charAt(i)) != -1) {
                        mismatchingPos++;
                    }
                }
            }
        }
    }
}
