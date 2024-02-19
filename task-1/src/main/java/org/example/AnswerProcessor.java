package org.example;

import java.util.Objects;

public class AnswerProcessor {
    private int matchingPos = 0;
    private int misMatchingPos = 0;
    private boolean isAnswered = false;

    public int getMatchingPos() {
        return matchingPos;
    }

    public int getMisMatchingPos() {
        return misMatchingPos;
    }

    public boolean isGuessed() {
        return isAnswered;
    }

    public void check(String guess, String answer) {
        matchingPos = 0;
        misMatchingPos = 0;
        if (Objects.equals(guess, answer)) {
            isAnswered = true;
            matchingPos = 4;
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == answer.charAt(i)) {
                    matchingPos++;
                }
                else {
                    if (answer.indexOf(guess.charAt(i)) != -1) {
                        misMatchingPos++;
                    }
                }
            }
        }
    }
}
