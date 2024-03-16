package org.nextples.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sub implements NonParameterCommand {
    private static final Logger logger = LoggerFactory.getLogger(Sub.class);

    @Override
    public void execute(ExecutionContext context) throws IllegalAccessException {
        logger.info("Command - is being run");
        if (context.getStack().empty()) {
            logger.error("Attempt to access an element from an empty stack");
            throw new IllegalAccessException("Attempt to access an element from an empty stack");
        }
        double arg2 = (double) context.getStack().peek();
        context.getStack().pop();

        if (context.getStack().empty()) {
            logger.error("Attempt to access an element from an empty stack");
            throw new IllegalAccessException("Attempt to access an element from an empty stack");
        }
        double arg1 = (double) context.getStack().peek();
        context.getStack().pop();

        double result = arg1 - arg2;
        context.getStack().push(result);
        logger.info("Command - was executed successfully");
    }
}
