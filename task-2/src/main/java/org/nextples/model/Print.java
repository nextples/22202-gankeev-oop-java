package org.nextples.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Print implements NonParameterCommand {
    private static final Logger logger = LoggerFactory.getLogger(Print.class);

    @Override
    public void execute(ExecutionContext context) throws IllegalAccessException {
        logger.info("Command PRINT is being run");
        if (context.getStack().empty()) {
            logger.error("Attempt to access an element from an empty stack");
            throw new IllegalAccessException("Attempt to print an element from the empty stack");
        }
        System.out.println(context.getStack().peek());
        logger.info("Command PRINT was executed successfully");
    }
}
