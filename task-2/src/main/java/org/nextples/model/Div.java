package org.nextples.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Div implements NonParameterCommand {
    private static final Logger logger = LoggerFactory.getLogger(Div.class);

    @Override
    public void execute(ExecutionContext context) throws ArithmeticException, IllegalAccessException {
        logger.info("Command / is being run");
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

        if (arg2 == 0) {
            logger.error("Invalid division by zero: {} 7 {}", arg1, arg2);
            throw new ArithmeticException("Invalid division by zero: " + arg1 + " / " + arg2);
        }
        double result = arg1 / arg2;
        context.getStack().push(result);
        logger.info("Command / was executed successfully");
    }
}
