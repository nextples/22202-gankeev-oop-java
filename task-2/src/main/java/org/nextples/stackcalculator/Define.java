package org.nextples.stackcalculator;

import org.nextples.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Define implements ParameterCommand {
    private static final Logger logger = LoggerFactory.getLogger(Define.class);

    @Override
    public void execute(List<String> args, ExecutionContext context) throws IllegalArgumentException {
        logger.info("Command DEFINE is being run with arguments {}", args);
        if (!isArgsValid(args)) {
            logger.error("Command DEFINE received incorrect arguments: " + args);
            throw new IllegalArgumentException("Command DEFINE received incorrect arguments: " + args);
        }
        else {
            context.getParameters().put(args.get(0), Double.parseDouble(args.get(1)));
        }
        logger.info("Command DEFINE was executed successfully");
    }

    private boolean isArgsValid(List<String> args) {
        return ((args.size() == 2) && isParameterName(args.get(0)) && isValue(args.get(1)));
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
