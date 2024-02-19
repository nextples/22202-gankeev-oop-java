package org.example;

public class DigitValidator {
    public static boolean isNumberValid(String number, int length) {
        int counter = 0;
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);

            if (digit <= '9' && digit >= '0') {
                counter++;
            }
        }
        return (counter == length && counter == number.length());
    }

}
