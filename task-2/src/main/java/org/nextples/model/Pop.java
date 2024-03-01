package org.nextples.stackcalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pop implements NonParameterCommand {
    private static final Logger logger = LoggerFactory.getLogger(Pop.class);

    @Override
    public void execute(ExecutionContext context) throws IllegalAccessException {
        logger.info("Command POP is being run");
        if (context.getStack().empty()) {
            logger.error("Attempt to access an element from an empty stack");
            throw new IllegalAccessException("Attempt to pop an element from the empty stack");
        }

        context.getStack().pop();
        logger.info("Command POP was executed successfully");
    }
}
