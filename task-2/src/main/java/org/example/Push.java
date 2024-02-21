package org.example;

import java.util.regex.*;

public class Push implements ParameterCommand{

    @Override
    public void execute(String args, ExecutionContext context) {
        args = args.replaceAll(" ", "");

        if (isNumber(args)) {
            double value = Double.parseDouble(args);
            context.stackPush(value);
        }
        else {
            // Найти по параметру значение в мапе и положить значение в стек
            try {
                double value = context.mapGet(args);
                context.stackPush(value);
            }
            catch (NullPointerException e) {
                System.err.println("an unknown parameter was passed ТУТ ДОБАВИТЬ НАДО ПОДРОБНОСТИ ВЫВОДА");
                System.exit(1);
            }
//            context.stackPush(value);
        }
    }

    private boolean isNumber(String args) {
        Pattern numberPattern = Pattern.compile("^((-?[0-9]+\\.[0-9]+)|(-?[1-9][0-9]*))$");
        Matcher numberMatcher = numberPattern.matcher(args);
        return numberMatcher.find();
    }
}
