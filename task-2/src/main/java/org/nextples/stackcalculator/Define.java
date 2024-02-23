package org.nextples.stackcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Define implements ParameterCommand {

    @Override
    public void execute(String args, ExecutionContext context) throws InvalidArgumentException {
        if (!isArgsValid(args)) {
            throw new InvalidArgumentException("Command " + this + " received incorrect arguments\n");
        }
        context.mapPut(getKey(args), getVal(args));
    }

    private boolean isArgsValid(String args) {
        Pattern defineArgPattern = Pattern.compile("^ *[A-z][0-z_]* ((-?[0-9]+\\.[0-9]+)|(-?[1-9][0-9]*)) *$");
        Matcher defineArgMatcher = defineArgPattern.matcher(args);
        return defineArgMatcher.find();
    }

    private String getKey(String args) {
        String[] parsedArgs = args.split(" ");
        Pattern keyPattern = Pattern.compile("^[A-z][0-z_]*$");
        for (int i = 0; i < parsedArgs.length; i++) {
            Matcher keyMatcher = keyPattern.matcher(parsedArgs[i]);
            if (keyMatcher.find()) {
                return parsedArgs[i];
            }
        }
        return null;
    }

    private Double getVal(String args) {
        String[] parsedArgs = args.split(" ");
        Pattern keyPattern = Pattern.compile("^((-?[0-9]+\\.[0-9]+)|(-?[1-9][0-9]*))$");
        for (int i = 0; i < parsedArgs.length; i++) {
            Matcher keyMatcher = keyPattern.matcher(parsedArgs[i]);
            if (keyMatcher.find()) {
                return Double.parseDouble(parsedArgs[i]);
            }
        }
        return null;
    }
}
