package org.nextples.stackcalculator.command;

import java.util.Objects;
import java.util.regex.*;

public class CommandValidator {
    public static boolean isValid(String command) {
        Pattern popPattern = Pattern.compile("^POP\s*$");
        Pattern pushPattern = Pattern.compile("^PUSH ((-?[0-9]+\\.[0-9]+)|(-?[1-9][0-9]*)|([A-z][0-z_]*)) *$");
        Pattern plusPattern = Pattern.compile("^PLUS *$");
        Pattern subPattern = Pattern.compile("^SUB *$");
        Pattern mulPattern = Pattern.compile("^MUL *$");
        Pattern divPattern = Pattern.compile("^DIV *$");
        Pattern sqrtPattern = Pattern.compile("^SQRT *$");
        Pattern printPattern = Pattern.compile("^PRINT *$");
        Pattern definePattern = Pattern.compile("^DEFINE [A-z][0-z_]* ((-?[0-9]+\\.[0-9]+)|(-?[1-9][0-9]*)) *$");

        Matcher popMatcher = popPattern.matcher(command);
        Matcher pushMatcher = pushPattern.matcher(command);
        Matcher plusMatcher = plusPattern.matcher(command);
        Matcher subMatcher = subPattern.matcher(command);
        Matcher mulMatcher = mulPattern.matcher(command);
        Matcher divMatcher = divPattern.matcher(command);
        Matcher sqrtMatcher = sqrtPattern.matcher(command);
        Matcher printMatcher = printPattern.matcher(command);
        Matcher defineMatcher = definePattern.matcher(command);

        return isComment(command) || popMatcher.find() || pushMatcher.find() || plusMatcher.find()
                || subMatcher.find() || mulMatcher.find() || divMatcher.find() || sqrtMatcher.find()
                || printMatcher.find() || defineMatcher.find();
    }

    public static boolean isComment(String command) {
        return (Objects.equals(command, "")) || (command.charAt(0) == '#');
    }

}
