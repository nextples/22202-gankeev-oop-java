package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberCreator {
    public static String create() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);

        String stringNumber = "";
        for (int i = 0; i < 4; i++) {
            stringNumber += Integer.toString(digits.get(i));
        }
        return stringNumber;
    }
}
