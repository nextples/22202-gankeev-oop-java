package org.nextples.stackcalculator;

import java.util.EmptyStackException;

public class Pop implements NonParameterCommand {

    @Override
    public void execute(ExecutionContext context) throws EmptyStackException {
        context.stackPop();
    }
}
