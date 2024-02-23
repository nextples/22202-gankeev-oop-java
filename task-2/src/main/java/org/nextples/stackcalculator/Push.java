package org.nextples.stackcalculator;

import java.util.Objects;
import java.util.regex.*;

public class Push implements ParameterCommand{

    @Override
    public void execute(String args, ExecutionContext context) throws InvalidArgumentException, InvalidParameterNameException {
        if (!isArgsValid(args)) {
            throw new InvalidArgumentException("Command " + this + " received incorrect arguments\n");
        }

        args = args.replaceAll(" ", "");
        if (isNumber(args)) {
            double value = Double.parseDouble(args);
            context.stackPush(value);
        }
        else {
            double value = context.mapGet(args);
            if (Objects.isNull(context.mapGet(args))) {
                throw new InvalidParameterNameException("Command " + this + " received unknown parameter " + args);
            }
            context.stackPush(value);
        }
    }

    private boolean isArgsValid(String args) {
        Pattern pushArgPattern = Pattern.compile("^ *((-?[0-9]+\\.[0-9]+)|(-?[1-9][0-9]*)|([A-z][0-z_]*)) *$");
        Matcher pushArgMatcher = pushArgPattern.matcher(args);
        return pushArgMatcher.find();
    }

    private boolean isNumber(String args) {
        Pattern numberPattern = Pattern.compile("^((-?[0-9]+\\.[0-9]+)|(-?[1-9][0-9]*))$");
        Matcher numberMatcher = numberPattern.matcher(args);
        return numberMatcher.find();
    }
}
