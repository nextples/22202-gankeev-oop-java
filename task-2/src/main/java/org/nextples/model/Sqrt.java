package org.nextples.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.sqrt;

public class Sqrt implements NonParameterCommand {
    private static final Logger logger = LoggerFactory.getLogger(Sqrt.class);

    @Override
    public void execute(ExecutionContext context) throws ArithmeticException, IllegalAccessException {
        logger.info("Command SQRT is being run");
        if (context.getStack().empty()) {
            logger.error("Attempt to access an element from an empty stack");
            throw new IllegalAccessException("Attempt to access an element from an empty stack");
        }
        double arg = (double) context.getStack().peek();
        context.getStack().pop();

        if (arg < 0) {
            logger.error("Attempt to access an element from an empty stack");
            throw new ArithmeticException("Invalid extraction of the square root of " + arg);
        }
        else {
            double result = sqrt(arg);
            context.getStack().push(result);
        }
        logger.info("Command SQRT was executed successfully");
    }
}
