package org.nextples.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.*;

public class Push implements ParameterCommand {
    private static final Logger logger = LoggerFactory.getLogger(Push.class);

    @Override
    public void execute(List<String> args, ExecutionContext context) throws IllegalArgumentException {
        logger.info("Command PUSH is being run with arguments {}", args);
        if (!isArgsValid(args)) {
            logger.error("Command PUSH received incorrect arguments: {}", args);
            throw new IllegalArgumentException("Command PUSH received incorrect arguments: " + args);
        }
        String arg = args.getFirst();
        if (isParameterName(arg) && !context.getParameters().containsKey(arg)) {
            logger.error("Command PUSH received unknown parameter: {}", arg);
            throw new IllegalArgumentException("Command PUSH received unknown parameter: " + arg);
        }

        double value;
        if (isValue(arg)) {
            value = Double.parseDouble(arg);
        }
        else {
            value = (double) context.getParameters().get(arg);
        }
        context.getStack().push(value);
        logger.info("Command PUSH was executed successfully");

    }

    private boolean isArgsValid(List<String> args) {
        return ((args.size() == 1) && (isParameterName(args.getFirst()) | isValue(args.getFirst())));
    }

    private boolean isValue(String arg) {
        Pattern valuePattern = Pattern.compile("^((-?[0-9]+\\.[0-9]+)|(-?[1-9][0-9]*))$");
        Matcher valueMatcher = valuePattern.matcher(arg);
        return valueMatcher.find();
    }

    private boolean isParameterName(String arg) {
        Pattern parameterPattern = Pattern.compile("^[A-z][0-z_]*$");
        Matcher parameterMatcher = parameterPattern.matcher(arg);
        return parameterMatcher.find();
    }
}
